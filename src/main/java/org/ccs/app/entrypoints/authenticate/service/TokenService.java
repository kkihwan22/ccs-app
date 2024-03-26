package org.ccs.app.entrypoints.authenticate.service;

import org.ccs.app.core.authenticate.model.AuthenticationResult;
import org.ccs.app.entrypoints.authenticate.model.TokenIssueRequest;

public interface TokenService {

    AuthenticationResult reissued(TokenIssueRequest request);
}
