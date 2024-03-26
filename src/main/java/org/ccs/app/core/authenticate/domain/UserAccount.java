package org.ccs.app.core.authenticate.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ccs.app.core.share.authenticate.exception.IncorrectPasswordException;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_account")
@DynamicUpdate
@DynamicInsert
@Getter
@ToString(exclude = "roles")
public class UserAccount extends BaseCreatedAndUpdatedDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email; // login id

    @Column(name = "password")
    private String password; // login pw

    @OneToMany(mappedBy = "account")
    private List<UserRole> roles;

    @Column(name = "login_failure_count")
    private Integer loginFailureCount;

    @Column(name = "status")
    private AccountStatus status;

    @Column(name = "last_access_dt")
    private LocalDateTime lastAccessAt;

    @Column(name = "password_changed_dt")
    private LocalDateTime passwordChangedAt;

    public void confirmPassword(String password) {
        if (!Objects.equals(this.password, password)) {
            loginFailureCount = loginFailureCount + 1;
            if (loginFailureCount > 5) {
                this.status = AccountStatus.LOCKED;
            }
            throw new IncorrectPasswordException();
        }

        this.lastAccessAt = LocalDateTime.now();
        this.loginFailureCount = 0;
    }
}
