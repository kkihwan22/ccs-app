package org.ccs.app.entrypoints.authenticate.service;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.LoginUsecase;
import org.ccs.app.core.authenticate.application.usecase.SignupUsecase;
import org.ccs.app.core.authenticate.application.usecase.TokenIssueUsecase;
import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.model.SignupParameter;
import org.ccs.app.core.authenticate.model.TokenResult;
import org.ccs.app.entrypoints.authenticate.model.LoginRequest;
import org.ccs.app.entrypoints.authenticate.model.SignupRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final static Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    private final SignupUsecase signupUsecase;
    private final LoginUsecase loginUsecase;
    private final TokenIssueUsecase tokenIssueUsecase;

    @Override
    public void signup(SignupRequest request) {
        UserAccount account = signupUsecase.signup(new SignupParameter(request.getEmail(), request.getPassword()));
        // todo: 인증메일 발송
    }

    @Transactional
    @Override
    public TokenResult login(LoginRequest request) {
        UserAccount account = loginUsecase.authenticateUser(request.getEmail(), request.getPassword());
        return tokenIssueUsecase.issued(account);
    }
}
