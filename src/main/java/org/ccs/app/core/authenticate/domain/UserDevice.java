package org.ccs.app.core.authenticate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "user_device")
@DynamicUpdate
@DynamicInsert
@Getter
@ToString
public class UserDevice extends BaseCreatedAndUpdatedDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "raw_data")
    private String rawData;

    @Column(name = "created_at")
    @Getter
    private LocalDateTime createdDateTime;

    public UserDevice(String clientId, String rawData) {
        this.clientId = clientId;
        this.rawData = rawData;
    }
}
