package org.ccs.app.core.authenticate.model;

import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.domain.UserAccountStatus;

@Getter @ToString
public class SignupParameter {
    private String email;
    private String password;

    public SignupParameter(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserAccount toEntity() {
        return UserAccount.builder()
                .email(email)
                .password(password)
                .status(UserAccountStatus.UNVERIFIED)
                .build();
    }
}
