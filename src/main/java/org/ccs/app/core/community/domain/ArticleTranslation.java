package org.ccs.app.core.community.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ccs.app.core.share.code.LangCode;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTimeWithAudit;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article_translation")
@DynamicInsert
@DynamicUpdate
@Getter
@ToString
@Builder
public class ArticleTranslation extends BaseCreatedAndUpdatedDateTimeWithAudit {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;
    private LangCode langCode;
    private String title;
    private String content;
}
