package org.ccs.app.core.authenticate.application.usecase;

public interface EmailVerificationCodeCreateUsecase {

    void createCode(String email);
}
