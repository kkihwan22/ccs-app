package org.ccs.app.core.share.exception;

import lombok.Getter;

public class BusinessException extends RuntimeException {

    @Getter
    private int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException() {
        this(ErrorCode.UNKNOWN.getCode(), ErrorCode.UNKNOWN.getMessage());
    }
}
