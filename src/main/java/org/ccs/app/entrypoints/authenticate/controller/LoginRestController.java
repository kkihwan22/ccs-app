package org.ccs.app.entrypoints.authenticate.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.model.AuthenticationResult;
import org.ccs.app.entrypoints.authenticate.model.LoginRequest;
import org.ccs.app.entrypoints.authenticate.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginRestController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResult> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.authenticate(loginRequest));
    }
}
