package org.ccs.app.entrypoints.authenticate.service;

import org.ccs.app.entrypoints.authenticate.model.SignupRequest;

public interface AuthenticationService {

    void signup(SignupRequest request);
}
