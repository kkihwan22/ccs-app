package org.ccs.app.core.share.authenticate.exception;

import org.ccs.app.core.share.exception.ErrorCode;

public class InvalidAccessTokenException extends UnauthenticatedException {

    public InvalidAccessTokenException() {
        super(ErrorCode.INVALID_ACCESS_TOKEN);
    }
}
