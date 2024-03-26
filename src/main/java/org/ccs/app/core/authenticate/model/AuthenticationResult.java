package org.ccs.app.core.authenticate.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class AuthenticationResult {
    private final String tokenType = "Bearer";
    private String access;
    private String refresh;
    private boolean changedRefresh;

    public AuthenticationResult(String access, String refresh, boolean changedRefresh) {
        this.access = access;
        this.refresh = refresh;
        this.changedRefresh = changedRefresh;
    }

    public static AuthenticationResult issued(String access, String refresh) {
        return new AuthenticationResult(access, refresh, false);
    }

    public static AuthenticationResult changedRefresh(String access, String refresh) {
        return new AuthenticationResult(access, refresh, true);
    }
}
