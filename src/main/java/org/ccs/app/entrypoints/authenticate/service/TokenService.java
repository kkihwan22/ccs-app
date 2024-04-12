package org.ccs.app.entrypoints.authenticate.service;

import org.ccs.app.core.authenticate.model.TokenResult;
import org.ccs.app.entrypoints.authenticate.model.TokenIssueRequest;

public interface TokenService {

    TokenResult reissued(TokenIssueRequest request);
}
