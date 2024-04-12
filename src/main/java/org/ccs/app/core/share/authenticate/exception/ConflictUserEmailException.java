package org.ccs.app.core.share.authenticate.exception;

import org.ccs.app.core.share.exception.BusinessException;
import org.ccs.app.core.share.exception.ErrorCode;

public class ConflictUserEmailException extends BusinessException {

    public ConflictUserEmailException() {
        super(ErrorCode.CONFLICT_EMAIL.getCode(), ErrorCode.CONFLICT_EMAIL.getMessage());
    }
}
