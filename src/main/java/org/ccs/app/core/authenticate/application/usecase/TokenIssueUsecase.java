package org.ccs.app.core.authenticate.application.usecase;

import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.share.authenticate.token.JWTType;

public interface TokenIssueUsecase {

    String issued(UserAccount account, JWTType type);
}
