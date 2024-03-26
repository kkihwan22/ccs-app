package org.ccs.app.core.share.authenticate.exception;

import org.ccs.app.core.share.authenticate.token.JWTType;
import org.ccs.app.core.share.exception.ErrorCode;

public class NoSuchTokenException extends UnauthenticatedException {

    public NoSuchTokenException(int code, String message) {
        super(code, message);
    }

    public NoSuchTokenException(JWTType type) {
        this(ErrorCode.NO_SUCH_TOKEN.getCode(), ErrorCode.NO_SUCH_TOKEN.getMessage() + "Token Type - " + type.name());
    }
}
