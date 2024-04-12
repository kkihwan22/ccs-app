package org.ccs.app.core.authenticate.application.usecase;

import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.model.SignupParameter;

public interface SignupUsecase {

    UserAccount signup(SignupParameter parameter);
}
