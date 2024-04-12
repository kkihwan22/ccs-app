package org.ccs.app.core.authenticate.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.TokenIssueUsecase;
import org.ccs.app.core.authenticate.application.usecase.TokenReissueUsecase;
import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.model.TokenResult;
import org.ccs.app.core.share.authenticate.token.JWTType;
import org.ccs.app.core.share.authenticate.token.JWTUtil;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TokenApplication implements TokenIssueUsecase, TokenReissueUsecase {

    private final JWTUtil jwtUtil;

    @Override
    public TokenResult issued(UserAccount account) {
        return new TokenResult(jwtUtil.issued(
                JWTType.ACCESS, account.getId()),
                jwtUtil.issued(JWTType.REFRESH, account.getId()),
                JWTType.ACCESS.getExpirationMs());
    }

    @Override
    public TokenResult reissued(String token) {
        return null;
    }
}
