package org.ccs.app.entrypoints.share.controller;


import lombok.Getter;
import lombok.ToString;
import org.ccs.app.entrypoints.share.model.ContentBody;

@Getter
@ToString
public class ResponseFactory {
    private final static int SUCCESS_CODE = 0;
    private final static String SUCCESS_MESSAGE = "SUCCESS";

    public static <T> ContentBody<T> success(T data) {
        // TODO: TraceId 가져오는 방법 구현
        return new ContentBody<>(SUCCESS_CODE, SUCCESS_MESSAGE, "", data);
    }
}
