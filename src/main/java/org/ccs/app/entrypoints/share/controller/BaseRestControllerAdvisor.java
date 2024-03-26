package org.ccs.app.entrypoints.share.controller;

import org.ccs.app.core.share.authenticate.exception.UnauthenticatedException;
import org.ccs.app.entrypoints.share.exception.InvalidRequestParameterException;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.ccs.app.entrypoints.share.model.ErrorBindings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
public class BaseRestControllerAdvisor {
    private final Logger LOG = LoggerFactory.getLogger(BaseRestControllerAdvisor.class);

    @ExceptionHandler(InvalidRequestParameterException.class)
    public ContentBody<List<ErrorBindings>> handle(InvalidRequestParameterException e) {
        LOG.error("유효하지 않은 요청입니다: {}", e);
        return new ContentBody<>(400, "Bad request.", "", e.getErrors());
    }

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ContentBody<String> handleUnauthenticated(UnauthenticatedException e) {
        LOG.error("UnauthenticatedException. reason: {}", e.getMessage());
        return new ContentBody<>(e.getCode(), e.getMessage(), "", "인증되지 않은 요청입니다.");
    }

    @ExceptionHandler(Exception.class)
    public ContentBody handleException(Exception e) {
        LOG.error("Error가 발생하였습니다. {}", e);
        return new ContentBody(500, "Unknown error.", "", null);
    }
}
