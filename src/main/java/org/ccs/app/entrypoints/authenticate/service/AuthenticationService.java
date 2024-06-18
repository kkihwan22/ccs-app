package org.ccs.app.entrypoints.authenticate.service;

import org.ccs.app.entrypoints.authenticate.model.AuthenticationDTO.SignupRequest;

public interface AuthenticationService {
    void signup(SignupRequest request);

    void verifyEmail();
    void resendVerificationEmail();
    void resetPassword();
}
