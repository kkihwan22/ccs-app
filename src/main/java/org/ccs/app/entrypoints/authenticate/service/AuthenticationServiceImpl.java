package org.ccs.app.entrypoints.authenticate.service;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.SignupUsecase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static org.ccs.app.entrypoints.authenticate.model.AuthenticationDTO.SignupRequest;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final static Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    private final SignupUsecase signupUsecase;
    @Override
    public void signup(SignupRequest request) {
        signupUsecase.signup(request.to());
        // Email 발송
    }

    @Override
    public void verifyEmail() {

    }

    @Override
    public void resendVerificationEmail() {

    }

    @Override
    public void resetPassword() {

    }
}
