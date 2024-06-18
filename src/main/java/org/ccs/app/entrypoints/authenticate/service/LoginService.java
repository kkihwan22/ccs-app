package org.ccs.app.entrypoints.authenticate.service;

import org.ccs.app.entrypoints.authenticate.model.LoginDTO.LoginRequest;
import org.ccs.app.entrypoints.authenticate.model.LoginDTO.TokenResponse;

public interface LoginService {
    TokenResponse login(LoginRequest request);

    void logout(String token, Long id);

    TokenResponse reIssueToken(String token);
}
