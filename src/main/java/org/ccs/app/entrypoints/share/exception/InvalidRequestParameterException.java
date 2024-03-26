package org.ccs.app.entrypoints.share.exception;

import lombok.Getter;
import lombok.ToString;
import org.ccs.app.entrypoints.share.model.ErrorBindings;

import java.util.List;

@Getter @ToString
public class InvalidRequestParameterException extends RuntimeException{
    private final List<ErrorBindings> errors;

    public InvalidRequestParameterException(List<ErrorBindings> errors) {
        this.errors = errors;
    }
}
