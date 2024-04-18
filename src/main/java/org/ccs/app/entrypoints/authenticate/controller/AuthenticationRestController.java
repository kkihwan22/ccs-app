package org.ccs.app.entrypoints.authenticate.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.model.TokenResult;
import org.ccs.app.core.share.authenticate.AuthenticatedHolder;
import org.ccs.app.entrypoints.authenticate.model.LoginRequest;
import org.ccs.app.entrypoints.authenticate.model.SignupRequest;
import org.ccs.app.entrypoints.authenticate.service.AuthenticationService;
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
public class AuthenticationRestController implements BaseRestController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ContentBody<String> signup(@Valid @RequestBody SignupRequest request, BindingResult bindingResult) {
        hasError(bindingResult);
        authenticationService.signup(request);
        return ResponseFactory.success("success");
    }

    @PostMapping("/login")
    public ContentBody<TokenResult> login(@Valid @RequestBody LoginRequest loginRequest) {
        TokenResult result = authenticationService.login(loginRequest);
        return ResponseFactory.success(result);
    }

    @PostMapping("/logout")
    public ContentBody<String> logout(@Valid @NotBlank(message = "token is null.") @RequestHeader(value = "Authorization") String token) {
        Long id = AuthenticatedHolder.get().getAccountId();
        authenticationService.logout(token, id);
        return ResponseFactory.success("success");
    }


    // @PostMapping("/logout")

}
