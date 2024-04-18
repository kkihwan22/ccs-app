package org.ccs.app.core.authenticate.application.usecase;

import org.ccs.app.core.authenticate.model.LogoutParameter;

public interface TokenExpiredUsecase {

    void expired(LogoutParameter parameter);
}
