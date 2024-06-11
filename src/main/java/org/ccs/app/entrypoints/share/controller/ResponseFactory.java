package org.ccs.app.entrypoints.share.controller;


import lombok.Getter;
import lombok.ToString;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.ccs.app.entrypoints.share.model.PageBodyWrapper;
import org.ccs.app.entrypoints.share.model.SuccessBody;

// TODO: TRACE ID 설정
@Getter @ToString
public class ResponseFactory {
    private final static int SUCCESS_CODE = 0;
    private final static String SUCCESS_MESSAGE = "SUCCESS";

    public static <T> ContentBody<T> ok(T data) {
        return new ContentBody<>(SUCCESS_CODE, SUCCESS_MESSAGE, "", data);
    }

    public static <T> ContentBody<SuccessBody<T>> success(T data) {
        return new ContentBody<>(SUCCESS_CODE, SUCCESS_MESSAGE, "", new SuccessBody<>(data));
    }

    public static <T>PageBodyWrapper<T> pagingBy(T data, Long totalCount, Boolean prev, Boolean next) {
        return new PageBodyWrapper<>(SUCCESS_CODE, SUCCESS_MESSAGE, "", data, totalCount, prev, next);
    }
}
