package org.ccs.app.core.authenticate.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class LogoutParameter {

    private String token;
    private Long id;

    public LogoutParameter(String token, Long id) {
        this.token = token;
        this.id = id;
    }
}
