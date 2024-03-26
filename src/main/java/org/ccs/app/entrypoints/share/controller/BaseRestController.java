package org.ccs.app.entrypoints.share.controller;

import org.ccs.app.entrypoints.share.exception.InvalidRequestParameterException;
import org.ccs.app.entrypoints.share.model.ErrorBindings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Rest Controller 구현용
 */
public interface BaseRestController {
    Logger log = LoggerFactory.getLogger(BaseRestController.class);
    default void hasError(BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            return;
        }

        List<ErrorBindings> errors = bindingResult.getFieldErrors().stream()
                .map(err -> new ErrorBindings(err.getField(), err.getDefaultMessage()))
                .collect(Collectors.toList());
        log.debug("errors: {}", errors);
        throw new InvalidRequestParameterException(errors);
    }
}
