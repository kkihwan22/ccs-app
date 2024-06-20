package org.ccs.app.entrypoints.authenticate.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.ccs.app.core.share.authenticate.AuthenticatedHolder;
import org.ccs.app.entrypoints.authenticate.model.LoginDTO.LoginRequest;
import org.ccs.app.entrypoints.authenticate.model.LoginDTO.TokenResponse;
import org.ccs.app.entrypoints.authenticate.service.LoginService;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginRestController implements BaseRestController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ContentBody<TokenResponse> login(@Valid @RequestBody LoginRequest request, BindingResult bindingResult) {
        hasError(bindingResult);
        TokenResponse response = loginService.login(request);
        return ResponseFactory.ok(response);
    }

    @PostMapping("/logout")
    public ContentBody<String> logout(@Valid @NotBlank(message = "token is null.") @RequestHeader(value = "Authorization") String token) {
        Long id = AuthenticatedHolder.get().getAccountId();
        loginService.logout(token, id);
        return ResponseFactory.ok("success");
    }

    @PostMapping("/auth/reissue/access-token")
    public ContentBody<TokenResponse> reIssuedAccessToken(@RequestHeader(value = "Authorization") String token) {
        return null;
    }
}
