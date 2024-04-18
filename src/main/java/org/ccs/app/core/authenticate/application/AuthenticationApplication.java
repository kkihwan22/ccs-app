package org.ccs.app.core.authenticate.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.LoginUsecase;
import org.ccs.app.core.authenticate.application.usecase.SignupUsecase;
import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.infra.repository.TokenHistoryMongoRepository;
import org.ccs.app.core.authenticate.infra.repository.UserAccountJpaRepository;
import org.ccs.app.core.authenticate.model.SignupParameter;
import org.ccs.app.core.share.authenticate.exception.ConflictUserEmailException;
import org.ccs.app.core.share.authenticate.exception.IncorrectPasswordException;
import org.ccs.app.core.share.authenticate.exception.NoSuchUserException;
import org.ccs.app.core.share.authenticate.token.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class AuthenticationApplication implements SignupUsecase, LoginUsecase{
    private final UserAccountJpaRepository userAccountJpaRepository;
    private final TokenHistoryMongoRepository tokenHistoryMongoRepository;
    private final JWTUtil jwtUtil;


    @Override
    public UserAccount signup(SignupParameter parameter) {
        if(userAccountJpaRepository.existsByEmail(parameter.getEmail())) {
            throw new ConflictUserEmailException();
        }
        return userAccountJpaRepository.save(parameter.toEntity());
    }

    @Transactional(noRollbackFor = IncorrectPasswordException.class)
    @Override
    public UserAccount authenticateUser(String id, String password) {
        UserAccount account = getUserByEmail(id);
        account.confirmPassword(password);

        return account;
    }

//    @Override
//    public TokenResult reissued(String token) {
//        IssuedToken issuedTokenHistory = tokenHistoryMongoRepository.findTokenHistoryByToken(token)
//                .orElseThrow(() -> new NoSuchTokenException(REFRESH));
//
//        Long accountId = issuedTokenHistory.getAccountId();
//        String issuedAccess = jwtUtil.issued(ACCESS, accountId);
//        if (jwtUtil.verify(token)) {
//            return AuthenticationResult.issued(issuedAccess, token);
//        }
//
//        String issuedRefresh = jwtUtil.issued(REFRESH, accountId);
//        tokenHistoryMongoRepository.delete(issuedTokenHistory);
//        this.createTokenHistory(accountId, issuedRefresh);
//        return AuthenticationResult.changedRefresh(issuedAccess, issuedRefresh);

//        return null;
//    }

    private UserAccount getUserByEmail(String email) {
        return userAccountJpaRepository.findByEmail(email).orElseThrow(NoSuchUserException::new);
    }

//    private void createTokenHistory(Long accountId, String refresh) {
//        IssuedToken issuedToken = new IssuedToken(accountId, refresh);
//        tokenHistoryMongoRepository.save(issuedToken);
//    }
}
