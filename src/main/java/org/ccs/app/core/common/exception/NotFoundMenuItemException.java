package org.ccs.app.core.common.exception;

import org.ccs.app.core.share.exception.BusinessException;
import org.ccs.app.core.share.exception.ErrorCode;

public class NotFoundMenuItemException extends BusinessException {

    public NotFoundMenuItemException() {
        super(ErrorCode.NOT_FOUND_MENU.getCode(), ErrorCode.NOT_FOUND_MENU.getMessage());
    }
}
