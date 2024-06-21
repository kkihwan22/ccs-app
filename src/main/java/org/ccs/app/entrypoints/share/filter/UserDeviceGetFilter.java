package org.ccs.app.entrypoints.share.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.ccs.app.core.share.authenticate.UserDeviceDetails;
import org.ccs.app.core.share.authenticate.UserDeviceHolder;

import java.io.IOException;

public class UserDeviceGetFilter implements Filter {
    private static final String HEADER = "x-client-id";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        UserDeviceHolder.clear();
        UserDeviceHolder.setUserDeviceDetails(new UserDeviceDetails(request.getHeader(HEADER)));

        chain.doFilter(req, res);
    }
}
