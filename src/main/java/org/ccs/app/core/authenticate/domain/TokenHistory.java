package org.ccs.app.core.authenticate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@NoArgsConstructor
@Entity
@Table(name = "token_history")
@DynamicUpdate
@DynamicInsert
@Getter
@ToString
public class TokenHistory extends BaseCreatedAndUpdatedDateTime {
    private static final String TOKEN_TYPE = "Bearer";
    private static final String DEFAULT_VERSION = "v1";

    public enum ExpireReason {
        LOGOUT, EXPIRATION
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private UserAccount account;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "token_type")
    private String type;

    @Column(name = "version")
    private String version;

    @Column(name = "token")
    private String token;

    @Column(name = "expired")
    private Boolean expired;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "reason")
    private ExpireReason reason;

    public TokenHistory(UserAccount account, String clientId, String token) {
        this.account = account;
        this.clientId = clientId;
        this.token = token;
    }
}
