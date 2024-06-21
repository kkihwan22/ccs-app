package org.ccs.app.config;

import org.ccs.app.entrypoints.share.filter.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    private static Integer order = Integer.MIN_VALUE;

    @Bean
    public FilterRegistrationBean<MDCFilter> mdcFilter() {
        FilterRegistrationBean<MDCFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MDCFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(order);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CorsFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(++order);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<UserDeviceGetFilter> userDeviceGetFilter() {
        FilterRegistrationBean<UserDeviceGetFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UserDeviceGetFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(++order);
        return registrationBean;
    }

    /**
     * 요청에 대한 Payload를 로깅한다.
     * 응답에 대한 로깅은 별도로 구현해야 한다.(성능 확인 후 적용 예정)
     * @return
     */
//    @Bean
//    public FilterRegistrationBean<CommonsRequestLoggingFilter> requestLoggingFilter() {
//        FilterRegistrationBean<CommonsRequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
//
//        CommonsRequestLoggingFilter requestLoggingFilter = new CommonsRequestLoggingFilter();
//        requestLoggingFilter.setIncludeClientInfo(true);
//        requestLoggingFilter.setIncludeHeaders(true);
//        requestLoggingFilter.setIncludeQueryString(true);
//        requestLoggingFilter.setIncludePayload(true);
//        requestLoggingFilter.setMaxPayloadLength(10000);
//        requestLoggingFilter.setAfterMessagePrefix("REQUEST DATA : ");
//
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setFilter(requestLoggingFilter);
//        registrationBean.setOrder(10);
//
//        return registrationBean;
//    }

//    @Bean
//    public CommonsRequestLoggingFilter commonsRequestLoggingFilter() {
//        CommonsRequestLoggingFilter requestLoggingFilter = new CommonsRequestLoggingFilter();
//        requestLoggingFilter.setIncludeClientInfo(true);
//        requestLoggingFilter.setIncludeHeaders(true);
//        requestLoggingFilter.setIncludeQueryString(true);
//        requestLoggingFilter.setIncludePayload(true);
//        requestLoggingFilter.setMaxPayloadLength(10000);
//        requestLoggingFilter.setAfterMessagePrefix("REQUEST DATA : ");
//
//        return requestLoggingFilter;
//    }

    @Bean
    public FilterRegistrationBean<JWTFilter> jwtFilter() {
        FilterRegistrationBean<JWTFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JWTFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(++order);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> apiContextFilter() {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticationFilter());
        registrationBean.addUrlPatterns("/api");
        registrationBean.setOrder(++order);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AuthorizationFilter> adminContextFilter() {
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthorizationFilter());
        registrationBean.addUrlPatterns("/admin");
        registrationBean.setOrder(++order);
        return registrationBean;
    }
}
