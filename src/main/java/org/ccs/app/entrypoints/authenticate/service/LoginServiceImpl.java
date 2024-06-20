package org.ccs.app.entrypoints.authenticate.service;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.LoginUsecase;
import org.ccs.app.core.authenticate.application.usecase.SignupUsecase;
import org.ccs.app.core.authenticate.application.usecase.TokenExpiredUsecase;
import org.ccs.app.core.authenticate.application.usecase.TokenIssueUsecase;
import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.domain.UserAccountStatus;
import org.ccs.app.core.authenticate.model.LogoutParameter;
import org.ccs.app.core.share.authenticate.token.JWTType;
import org.ccs.app.core.share.exception.BusinessException;
import org.ccs.app.core.share.exception.ErrorCode;
import org.ccs.app.entrypoints.authenticate.model.LoginDTO.LoginRequest;
import org.ccs.app.entrypoints.authenticate.model.LoginDTO.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    private final SignupUsecase signupUsecase;
    private final LoginUsecase loginUsecase;
    private final TokenExpiredUsecase tokenExpiredUsecase;
    private final TokenIssueUsecase tokenIssueUsecase;

    @Transactional
    @Override
    public TokenResponse login(LoginRequest request) {
        UserAccount account = loginUsecase.authenticateUser(request.email(), request.password());

        if (Objects.equals(UserAccountStatus.UNVERIFIED, account.getStatus())) {
            throw new BusinessException(ErrorCode.NOT_VERIFIED_EMAIL);
        }

        return TokenResponse.of(tokenIssueUsecase.issued(account, JWTType.ACCESS), tokenIssueUsecase.issued(account, JWTType.REFRESH));
    }

    @Override
    public void logout(String token, Long id) {
        tokenExpiredUsecase.expired(new LogoutParameter(token,id));
    }

    @Override
    public TokenResponse reIssueToken(String token) {

        // is token refresh.?

        // 만약 만료시간이 ...... refresh도 재발급 //

        // access 재발급 ....


        return null;
    }
}
