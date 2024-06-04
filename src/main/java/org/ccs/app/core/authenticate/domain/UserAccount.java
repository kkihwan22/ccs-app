package org.ccs.app.core.authenticate.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ccs.app.core.authenticate.domain.converter.UserAccountStatusToStringConverter;
import org.ccs.app.core.share.authenticate.exception.IncorrectPasswordException;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
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

    @Column(name = "login_failure_count")
    private Integer loginFailureCount;

    @Column(name = "status")
    @Convert(converter = UserAccountStatusToStringConverter.class)
    private UserAccountStatus status;

    @Column(name = "last_access_dt")
    private LocalDateTime lastAccessAt;

    @Column(name = "password_changed_dt")
    private LocalDateTime passwordChangedAt;

    public UserAccount(String email, String password) {
        this.validateNullOrBlank(email);
        this.email = email;
        this.password = password;
    }

    private void validateNullOrBlank(String str) {
        if (Objects.isNull(str) || str.isBlank()) {
            throw new IllegalArgumentException("null이거나 공백일 수 없습니다.");
        }
    }


    public void confirmPassword(String password) {
        if (!Objects.equals(this.password, password)) {
            loginFailureCount = loginFailureCount + 1;
            if (loginFailureCount > 5) {
                this.status = UserAccountStatus.LOCKED;
            }
            throw new IncorrectPasswordException();
        }

        this.lastAccessAt = LocalDateTime.now();
        this.loginFailureCount = 0;
    }


}
