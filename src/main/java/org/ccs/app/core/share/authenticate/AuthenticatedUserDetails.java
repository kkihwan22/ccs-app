package org.ccs.app.core.share.authenticate;

import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.authenticate.domain.RoleCode;
import org.ccs.app.core.authenticate.domain.UserAccount;

import java.util.HashSet;
import java.util.Set;

@Getter @ToString
public class AuthenticatedUserDetails {
    private boolean authenticated;
    private Long accountId;
    private String email;
    private Set<RoleCode> roleCodes = new HashSet<>();

    // fixme: 나중에 추가 정보를 담는 용도....
    private UserDetails userDetails;

    public AuthenticatedUserDetails() {
        this.authenticated = false;
    }

    public AuthenticatedUserDetails(UserAccount account) {
        this.authenticated = true;
        this.accountId = account.getId();
        this.email = account.getEmail();
    }
}
