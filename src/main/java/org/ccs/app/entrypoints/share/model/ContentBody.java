package org.ccs.app.entrypoints.share.model;

import lombok.Getter;
import lombok.ToString;

// TODO: record 전환 후 side effect발생해서 rollback함
@Getter @ToString
public class ContentBody<T> {
    private int code;
    private String message;
    private String traceId;
    private T contents;

    public ContentBody(int code, String message, String traceId, T contents) {
        this.code = code;
        this.message = message;
        this.traceId = traceId;
        this.contents = contents;
    }
}