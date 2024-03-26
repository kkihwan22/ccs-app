package org.ccs.app.core.authenticate.domain;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Role {
    ADMIN, STAFF, CHIEF, OFFICER, MANAGER, TEACHER;

    public String getDisplayName(Locale locale) {
        return Role.getDisplayNameForRole(this, locale);
    }

    private static String getDisplayNameForRole(Role role, Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle("RoleMessages", locale);
        return messages.getString(role.name());
    }
}
