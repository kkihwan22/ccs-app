package org.ccs.app.entrypoints.authenticate.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.model.AuthenticationResult;
import org.ccs.app.entrypoints.authenticate.model.LoginRequest;
import org.ccs.app.entrypoints.authenticate.model.SignupRequest;
import org.ccs.app.entrypoints.authenticate.service.AuthenticationService;
import org.ccs.app.entrypoints.authenticate.service.LoginService;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationRestController implements BaseRestController {
    private final LoginService loginService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ContentBody<String> signupUserAccount(@Valid @RequestBody SignupRequest request, BindingResult bindingResult) {
        hasError(bindingResult);
        authenticationService.signup(request);
        return ResponseFactory.success("success");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResult> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.authenticate(loginRequest));
    }
}
