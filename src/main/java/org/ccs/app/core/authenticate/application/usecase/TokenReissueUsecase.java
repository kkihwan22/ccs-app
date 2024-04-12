package org.ccs.app.core.authenticate.application.usecase;

import org.ccs.app.core.authenticate.model.TokenResult;

public interface TokenReissueUsecase {
    TokenResult reissued(String token);
}
