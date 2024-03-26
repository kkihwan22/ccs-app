package org.ccs.app.core.share.authenticate.exception;

import org.ccs.app.core.share.exception.BusinessException;
import org.ccs.app.core.share.exception.ErrorCode;

public class UnauthenticatedException extends BusinessException {
    public UnauthenticatedException(int code, String message) {
        super(code, message);
    }

    public UnauthenticatedException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage());
    }

    public UnauthenticatedException() {
        this(ErrorCode.UNAUTHENTICATED);
    }
}