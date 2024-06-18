package org.ccs.app.core.authenticate.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.EmailVerificationCodeCreateUsecase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailVerificationApplication implements EmailVerificationCodeCreateUsecase {
    private final static Logger log = LoggerFactory.getLogger(EmailVerificationApplication.class);

    @Override
    public void createCode(String email) {

    }
}
