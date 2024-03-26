package org.ccs.app.core.authenticate.application.usecase;

import org.ccs.app.core.authenticate.model.AuthenticationResult;

public interface TokenReissueUsecase {
    AuthenticationResult reissued(String token);
}
