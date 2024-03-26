package org.ccs.app.entrypoints.authenticate.service;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.TokenReissueUsecase;
import org.ccs.app.core.authenticate.model.AuthenticationResult;
import org.ccs.app.entrypoints.authenticate.model.TokenIssueRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenServiceImpl implements TokenService {

    private final TokenReissueUsecase tokenReissueUsecase;

    @Override
    public AuthenticationResult reissued(TokenIssueRequest request) {
        return tokenReissueUsecase.reissued(request.getToken());
    }
}
