package org.ccs.app.core.authenticate.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.LoginUsecase;
import org.ccs.app.core.authenticate.application.usecase.LogoutUsecase;
import org.ccs.app.core.authenticate.application.usecase.TokenReissueUsecase;
import org.ccs.app.core.authenticate.domain.IssuedToken;
import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.infra.repository.TokenHistoryMongoRepository;
import org.ccs.app.core.authenticate.infra.repository.UserAccountJpaRepository;
import org.ccs.app.core.authenticate.model.AuthenticationResult;
import org.ccs.app.core.share.authenticate.exception.IncorrectPasswordException;
import org.ccs.app.core.share.authenticate.exception.NoSuchTokenException;
import org.ccs.app.core.share.authenticate.exception.NoSuchUserException;
import org.ccs.app.core.share.authenticate.token.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static org.ccs.app.core.share.authenticate.token.JWTType.ACCESS;
import static org.ccs.app.core.share.authenticate.token.JWTType.REFRESH;

@RequiredArgsConstructor
@Component
public class AuthenticationApplication implements LoginUsecase, LogoutUsecase, TokenReissueUsecase {
    private final UserAccountJpaRepository userAccountJpaRepository;
    private final TokenHistoryMongoRepository tokenHistoryMongoRepository;
    private final JWTUtil jwtUtil;

    @Transactional(noRollbackFor = IncorrectPasswordException.class)
    @Override
    public AuthenticationResult login(String id, String password) {
        UserAccount account = getUserByEmail(id);
        account.confirmPassword(password);

        AuthenticationResult result =
                AuthenticationResult.issued(jwtUtil.issued(ACCESS, account.getId()), jwtUtil.issued(REFRESH, account.getId()));

        this.createTokenHistory(account.getId(), result.getRefresh());
        return result;
    }

    @Override
    public void logout() {
        // FIXME: 나중에 구현할 기능
    }

    @Override
    public AuthenticationResult reissued(String token) {
        IssuedToken issuedTokenHistory = tokenHistoryMongoRepository.findTokenHistoryByToken(token)
                .orElseThrow(() -> new NoSuchTokenException(REFRESH));

        Long accountId = issuedTokenHistory.getAccountId();
        String issuedAccess = jwtUtil.issued(ACCESS, accountId);
        if (jwtUtil.verify(token)) {
            return AuthenticationResult.issued(issuedAccess, token);
        }

        String issuedRefresh = jwtUtil.issued(REFRESH, accountId);
        tokenHistoryMongoRepository.delete(issuedTokenHistory);
        this.createTokenHistory(accountId, issuedRefresh);
        return AuthenticationResult.changedRefresh(issuedAccess, issuedRefresh);
    }

    private UserAccount getUserByEmail(String email) {
        return userAccountJpaRepository.findByEmail(email).orElseThrow(NoSuchUserException::new);
    }

    private void createTokenHistory(Long accountId, String refresh) {
        IssuedToken issuedToken = new IssuedToken(accountId, refresh);
        tokenHistoryMongoRepository.save(issuedToken);
    }
}
