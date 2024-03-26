package org.ccs.app.entrypoints.authenticate.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.model.AuthenticationResult;
import org.ccs.app.entrypoints.authenticate.model.TokenIssueRequest;
import org.ccs.app.entrypoints.authenticate.service.TokenService;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenRestController implements BaseRestController {
    private final TokenService tokenService;

    @PostMapping("/access-token")
    public ContentBody<AuthenticationResult> reissuedAccessToken(@RequestBody @Valid TokenIssueRequest request, BindingResult bindingResult) {
        hasError(bindingResult);
        AuthenticationResult result = tokenService.reissued(request);
        return ResponseFactory.success(result);
    }
}
