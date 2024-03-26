package org.ccs.app.core.share.authenticate;

import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.authenticate.domain.Role;
import org.ccs.app.core.authenticate.domain.UserAccount;

import java.util.HashSet;
import java.util.Set;

@Getter @ToString
public class Authenticate {
    private boolean authenticated;
    private Long accountId;
    private String email;
    private Set<Role> roles = new HashSet<>();

    // fixme: 나중에 추가 정보를 담는 용도....
    private UserDetails userDetails;

    public Authenticate() {
        this.authenticated = false;
    }

    public Authenticate(UserAccount account) {
        this.authenticated = true;
        this.accountId = account.getId();
        this.email = account.getEmail();
    }
}
