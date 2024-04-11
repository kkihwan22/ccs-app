package org.ccs.app.entrypoints.share.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ccs.app.core.share.authenticate.Authenticate;
import org.ccs.app.core.share.authenticate.AuthenticateHolder;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

public class AuthenticationFilter implements Filter {
    // todo : Bean으로 등록
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

    private static final String[] included = {"/api", "/admin"};


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        boolean matched = Arrays.stream(included)
                .anyMatch(it -> httpServletRequest.getRequestURI().startsWith(it));

        if (matched) {
            Authenticate authenticate = AuthenticateHolder.get();
            if (!authenticate.isAuthenticated()) {
                sendUnauthenticatedResponse(response);
                return;
            }
        }

        chain.doFilter(request, response);
    }

    // todo : 분리 (filter단에서 응답할 때 다른 방법으로 구현)
    private void sendUnauthenticatedResponse(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        ContentBody<String> unauthenticatedBody = new ContentBody<>(
                HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized: 로그인이 필요합니다.",
                "",
                null);

        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setContentType("application/json;charset=UTF-8");
        httpResponse.getWriter().write(mapper.writeValueAsString(unauthenticatedBody));
    }
}