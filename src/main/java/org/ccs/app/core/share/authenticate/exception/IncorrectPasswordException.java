package org.ccs.app.core.share.authenticate.exception;

import org.ccs.app.core.share.exception.ErrorCode;

public class IncorrectPasswordException extends UnauthenticatedException {

    public IncorrectPasswordException() {
        super(ErrorCode.INCORRECT_PASSWORD);
    }
}
