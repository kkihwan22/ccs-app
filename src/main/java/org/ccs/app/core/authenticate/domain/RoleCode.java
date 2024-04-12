package org.ccs.app.core.authenticate.domain;

import java.util.Locale;
import java.util.ResourceBundle;

public enum RoleCode {
    ADMIN, STAFF, CHIEF, OFFICER, MANAGER, TEACHER, USER;

    public String getDisplayName(Locale locale) {
        return RoleCode.getDisplayNameForRole(this, locale);
    }

    private static String getDisplayNameForRole(RoleCode roleCode, Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle("RoleMessages", locale);
        return messages.getString(roleCode.name());
    }
}
