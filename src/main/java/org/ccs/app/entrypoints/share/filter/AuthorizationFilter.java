package org.ccs.app.entrypoints.share.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.ccs.app.core.authenticate.domain.RoleCode;
import org.ccs.app.core.share.authenticate.AuthenticatedHolder;
import org.ccs.app.core.share.authenticate.AuthenticatedUserDetails;
import org.ccs.app.entrypoints.share.model.ContentBody;

import java.io.IOException;

public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        boolean skip = true;
        if (!skip) {
            AuthenticatedUserDetails authenticatedUserDetails = AuthenticatedHolder.get();

            if (!hasAdminRole(authenticatedUserDetails)) {
                sendAccessDeniedResponse(response);
            }
        }

        chain.doFilter(request, response);
    }

    private boolean hasAdminRole(AuthenticatedUserDetails authenticatedUserDetails) {
        return authenticatedUserDetails != null && authenticatedUserDetails.getRoleCodes().contains(RoleCode.ADMIN);
    }

    private void sendAccessDeniedResponse(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        ContentBody<String> accessDeniedBody = new ContentBody<>(
                HttpServletResponse.SC_FORBIDDEN,
                "Access Denied: 관리자 권한이 필요합니다.",
                "",
                null);

        ObjectMapper mapper = new ObjectMapper();

        httpResponse.setContentType("application/json");
        httpResponse.getWriter().write(mapper.writeValueAsString(accessDeniedBody));
    }
}