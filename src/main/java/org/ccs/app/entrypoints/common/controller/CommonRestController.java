package org.ccs.app.entrypoints.common.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.common.service.CommonService;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.ccs.app.entrypoints.share.model.SuccessBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RequiredArgsConstructor
@RestController
public class CommonRestController implements BaseRestController {
    private final CommonService commonService;

    @PostMapping("/public/v1/commons/client-id")
    public ContentBody<SuccessBody<String>> issueClientId(
            HttpServletResponse response,
            @RequestHeader(name = "User-Agent") String userAgent) {
        String clientId = commonService.issueClientId(userAgent);

        ResponseCookie cookie = ResponseCookie.from("clientId", clientId)
                .httpOnly(true)
                .path("/")
                .maxAge(Duration.ofDays(365))
                .sameSite("Strict")
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseFactory.success(clientId);
    }
}
