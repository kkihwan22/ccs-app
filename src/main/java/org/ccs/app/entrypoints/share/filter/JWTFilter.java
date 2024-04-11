package org.ccs.app.entrypoints.share.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.infra.repository.UserAccountJpaRepository;
import org.ccs.app.core.share.authenticate.Authenticate;
import org.ccs.app.core.share.authenticate.AuthenticateHolder;
import org.ccs.app.core.share.authenticate.exception.InvalidAccessTokenException;
import org.ccs.app.core.share.authenticate.exception.NoSuchUserException;
import org.ccs.app.core.share.authenticate.token.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * JWT 유무 판단 (orders: 3)
 * JWT가 있다면 유저의 정보를 조회한다.
 */
public class JWTFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(JWTFilter.class);
    private static final String AUTHORIZATION = "Authorization";
    // private static final String[] exclude = {"/login", "/public", "/access-token", "/publish"};

    private JWTUtil jwtUtil;
    private UserAccountJpaRepository userAccountJpaRepository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        this.jwtUtil = webApplicationContext.getBean(JWTUtil.class);
        this.userAccountJpaRepository = webApplicationContext.getBean(UserAccountJpaRepository.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // todo: 성능에 영향이 가는지 테스트 해보고 싶다.
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            String token = httpServletRequest.getHeader(AUTHORIZATION);
            log.debug("[authorization] {}", token);

            this.setAuthenticate(token);
            chain.doFilter(request, response);
        } finally {
            AuthenticateHolder.clear();
        }
    }

    /**
     * token 정보가 null 이면 Authenticated = false를 전달
     * token 정보가 존재한다면 유효성을 검증
     * token에 저장된 유저 조회 후 Authenticated에 셋팅
     * @param token
     * @return
     */
    private void setAuthenticate(String token) {
        if (Objects.isNull(token)) {
            AuthenticateHolder.setAuthenticate(new Authenticate());
            return;
        }

        if (!token.startsWith("Bearer "))
            throw new InvalidAccessTokenException();

        token = token.substring(7);
        if (!jwtUtil.verify(token))
            throw new InvalidAccessTokenException();

        Long accountId = (Long) jwtUtil.decode(token);
        log.debug("[account]: {}", accountId);

        UserAccount account = userAccountJpaRepository.findById(accountId).orElseThrow(NoSuchUserException::new);
        AuthenticateHolder.setAuthenticate(new Authenticate(account));
    }


}
