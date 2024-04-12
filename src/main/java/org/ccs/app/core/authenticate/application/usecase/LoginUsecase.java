package org.ccs.app.core.authenticate.application.usecase;

import org.ccs.app.core.authenticate.domain.UserAccount;

public interface LoginUsecase {

    UserAccount authenticateUser(String id, String password);
}
