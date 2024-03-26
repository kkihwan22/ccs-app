package org.ccs.app.entrypoints.share.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class PageBody<T> {
    private final ContentBody<T> contentBody;
    private final Long totalContent;
    private final Boolean prev;
    private final Boolean next;

    public PageBody(int code, String message, String traceId, T contents, Long totalContent, Boolean prev, Boolean next) {
        this.contentBody = new ContentBody<>(code, message, traceId, contents);
        this.totalContent = totalContent;
        this.next = next;
        this.prev = prev;
    }

    public PageBody(int code, String message, String traceId, T contents, Long totalContent) {
        this(code, message, traceId, contents, totalContent, null, null);
    }
}
