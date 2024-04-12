package org.ccs.app.core.authenticate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.ccs.app.core.authenticate.domain.converter.RoleCodeToStringConverter;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@NoArgsConstructor
@Entity
@Table(name = "user_account_role")
@DynamicInsert
@DynamicUpdate
@Getter
@ToString(exclude = "account")
public class UserAccountRole extends BaseCreatedAndUpdatedDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    @Convert(converter = RoleCodeToStringConverter.class)
    private RoleCode roleCode;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount account;

    public UserAccountRole(RoleCode roleCode) {
        this.roleCode = roleCode;
    }
}
