package org.ccs.app.core.authenticate.application.usecase;

import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.model.TokenResult;

public interface TokenIssueUsecase {

    TokenResult issued(UserAccount account);
}
