package org.ccs.app.core.share.authenticate;

public class UserDeviceHolder {
    private static final ThreadLocal<UserDeviceDetails> userDeviceHolder = new ThreadLocal<>();

    public static void setUserDeviceDetails(UserDeviceDetails userDeviceDetails) {
        userDeviceHolder.set(userDeviceDetails);
    }

    public static UserDeviceDetails get() {
        return userDeviceHolder.get();
    }

    public static void clear() {
        userDeviceHolder.remove();
    }
}
