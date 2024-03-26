package org.ccs.app.core.share.authenticate.token;

import lombok.Getter;
import lombok.Setter;

public enum JWTType {

    ACCESS(60 * 60 * 1000l)
    ,
    REFRESH(60 * 60 * 24 * 7 * 1000l)
    ,

    ;

    JWTType(long expirationMs) {
        this.expirationMs = expirationMs;
    }

    @Getter @Setter
    private long expirationMs;
}
