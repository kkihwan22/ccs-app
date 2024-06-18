package org.ccs.app.core.authenticate.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.TokenExpiredUsecase;
import org.ccs.app.core.authenticate.application.usecase.TokenIssueUsecase;
import org.ccs.app.core.authenticate.application.usecase.TokenReissueUsecase;
import org.ccs.app.core.authenticate.domain.TokenHistory;
import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.infra.repository.TokenHistoryJpaRepository;
import org.ccs.app.core.authenticate.model.LogoutParameter;
import org.ccs.app.core.share.authenticate.exception.NoSuchTokenException;
import org.ccs.app.core.share.authenticate.token.JWTType;
import org.ccs.app.core.share.authenticate.token.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class TokenApplication implements TokenIssueUsecase, TokenReissueUsecase, TokenExpiredUsecase {
    private final TokenHistoryJpaRepository tokenHistoryJpaRepository;
    private final JWTUtil jwtUtil;

    @Transactional
    @Override
    public String issued(UserAccount account, JWTType type) {
        return jwtUtil.issued(type, account.getId());

//        TokenHistory tokenHistory = TokenHistory.builder()
//                .accountId(account.getId())
//                .token(token)
//                .expiredAt(result.getExpiredAt())
//                .build();
//
//        tokenHistoryJpaRepository.save(tokenHistory);

    }

    @Override
    public String reissued(String token) {
        return null;
    }

    @Override
    public void expired(LogoutParameter parameter) {
        TokenHistory result = this.getByTokenAndAccountId(parameter.getToken(), parameter.getId());
        tokenHistoryJpaRepository.delete(result);
    }

    private TokenHistory getByTokenAndAccountId(String token, Long accountId) {
        return tokenHistoryJpaRepository.findTokenHistoryByTokenAndAccountId(token, accountId)
                .orElseThrow(() -> new NoSuchTokenException(JWTType.REFRESH));
    }
}
