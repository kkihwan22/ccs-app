package org.ccs.app.core.share.authenticate;

public class AuthenticatedHolder {
    private static final ThreadLocal<AuthenticatedUserDetails> authenticateHolder = new ThreadLocal<>();

    public static void setAuthenticate(AuthenticatedUserDetails authenticatedUserDetails) {
        authenticateHolder.set(authenticatedUserDetails);
    }

    public static AuthenticatedUserDetails get() {
        return authenticateHolder.get();
    }

    public static void clear() {
        authenticateHolder.remove();
    }
}
