package org.ccs.app.entrypoints.share.model;

import lombok.Getter;
import lombok.ToString;

@ToString @Getter
public class SuccessBody<T> {
    private T result;

    public SuccessBody(T result) {
        this.result = result;
    }
}
