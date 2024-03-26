package org.ccs.app.entrypoints.authenticate.service;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.LoginUsecase;
import org.ccs.app.core.authenticate.model.AuthenticationResult;
import org.ccs.app.core.share.authenticate.token.JWTUtil;
import org.ccs.app.entrypoints.authenticate.model.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final Logger log = LoggerFactory.getLogger(LoginService.class);
    private final LoginUsecase loginUsecase;
    private final JWTUtil jwtUtil;

    public AuthenticationResult authenticate(LoginRequest loginRequest) {
        return loginUser(loginRequest);
    }

    private AuthenticationResult loginUser(LoginRequest loginRequest) {
        return loginUsecase.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
