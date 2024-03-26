package org.ccs.app.entrypoints.share.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

public class MDCFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(MDCFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final UUID uuid = UUID.randomUUID();
        MDC.put("traceId", uuid.toString());

        try {
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}
