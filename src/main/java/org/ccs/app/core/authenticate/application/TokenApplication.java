package org.ccs.app.core.authenticate.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.TokenIssueUsecase;
import org.ccs.app.core.authenticate.application.usecase.TokenReissueUsecase;
import org.ccs.app.core.authenticate.domain.TokenHistory;
import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.infra.repository.TokenHistoryJpaRepository;
import org.ccs.app.core.authenticate.model.TokenResult;
import org.ccs.app.core.share.authenticate.token.JWTType;
import org.ccs.app.core.share.authenticate.token.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class TokenApplication implements TokenIssueUsecase, TokenReissueUsecase {
    private final TokenHistoryJpaRepository tokenHistoryJpaRepository;
    private final JWTUtil jwtUtil;

    @Transactional
    @Override
    public TokenResult issued(UserAccount account) {
        TokenResult result = new TokenResult(jwtUtil.issued(
                JWTType.ACCESS, account.getId()),
                jwtUtil.issued(JWTType.REFRESH, account.getId()),
                JWTType.ACCESS.getExpirationMs());

        TokenHistory tokenHistory = TokenHistory.builder()
                .userId(account.getId())
                .token(result.getRefreshToken())
                .expiredAt(result.getExpiredAt())
                .build();

        tokenHistoryJpaRepository.save(tokenHistory);
        return result;
    }

    @Override
    public TokenResult reissued(String token) {
        return null;
    }
}
