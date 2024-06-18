package org.ccs.app.core.share.exception;

import lombok.Getter;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Error Code 정리
 *  공용      : SHARE (UserAccount 포함) (0-999)
 *  공통 도메인 : COMMON (1000-1999)
 *  유저 도메인 : USER   (2000-2999)
 *  (계속추가)
 */
public enum ErrorCode {
    UNKNOWN(100, "UNKNOWN"),
    UNAUTHENTICATED(101, "UNAUTHORIZED_ACCESS"),
    NO_SUCH_USER(102,"NO_SUCH_USER"),
    INCORRECT_PASSWORD(103, "INCORRECT_PASSWORD"),
    NO_SUCH_TOKEN(104, "NO_SUCH_TOKEN"),
    INVALID_ACCESS_TOKEN(105, "INVALID_ACCESS_TOKEN"),
    NOT_VERIFIED_EMAIL(106, "NOT_VERIFIED_EMAIL"),


    CONFLICT_EMAIL(201, "CONFLICT_EMAIL"),

    NOT_FOUND_MENU(1000, "NOT_FOUND_MENU")
    ;

    @Getter
    int code;

    @Getter
    String message;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("errorMessages", locale);
        return bundle.getString(message);
    }
}
