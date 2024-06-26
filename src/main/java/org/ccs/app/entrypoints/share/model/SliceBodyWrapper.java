package org.ccs.app.entrypoints.share.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class SliceBodyWrapper<T> extends ContentBody<T> {

    private final Boolean next;

    public SliceBodyWrapper(int code, String message, String traceId, T contents, Boolean next) {
        super(code, message, traceId, contents);
        this.next = next;
    }

    public SliceBodyWrapper(int code, String message, String traceId, T contents) {
        this(code, message, traceId, contents, null);
    }
}
