package org.ccs.app.core.share.authenticate.exception;

import org.ccs.app.core.share.exception.ErrorCode;

public class NoSuchUserException extends UnauthenticatedException {

    public NoSuchUserException() {
        super(ErrorCode.NO_SUCH_USER);
    }
}
