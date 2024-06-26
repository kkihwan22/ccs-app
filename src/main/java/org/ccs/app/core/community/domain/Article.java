package org.ccs.app.core.community.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTimeWithAudit;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
@DynamicInsert
@DynamicUpdate
@Getter @ToString
@Builder
public class Article extends BaseCreatedAndUpdatedDateTimeWithAudit {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    private String title;
    private String content;
}
