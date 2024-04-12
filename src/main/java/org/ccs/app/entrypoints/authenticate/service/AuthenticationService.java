package org.ccs.app.entrypoints.authenticate.service;

import org.ccs.app.core.authenticate.model.TokenResult;
import org.ccs.app.entrypoints.authenticate.model.LoginRequest;
import org.ccs.app.entrypoints.authenticate.model.SignupRequest;

public interface AuthenticationService {

    void signup(SignupRequest request);
    TokenResult login(LoginRequest request);
}
