package org.ccs.app.entrypoints.share.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class PageBodyWrapper<T> extends ContentBody<T> {
    private final Long totalContent;
    private final Boolean prev;
    private final Boolean next;

    public PageBodyWrapper(int code, String message, String traceId, T contents, Long totalContent, Boolean prev, Boolean next) {
        super(code, message,traceId, contents);
        this.totalContent = totalContent;
        this.prev = prev;
        this.next = next;
    }

    public PageBodyWrapper(int code, String message, String traceId, T contents, Long totalContent) {
        this(code, message, traceId, contents, totalContent, null, null);
    }
}
