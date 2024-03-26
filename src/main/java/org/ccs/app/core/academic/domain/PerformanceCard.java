package org.ccs.app.core.academic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "performance_card")
@DynamicInsert @DynamicUpdate
@NoArgsConstructor @AllArgsConstructor
@Getter @ToString
public class PerformanceCard extends BaseCreatedAndUpdatedDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date; // yyyyMMdd

//    아직 student 테이블이 없기 때문에 임시 필드 사용하기
    @Column(name = "student_id")
    private Long studentId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "attendance", column = @Column(name = "attendance")),
            @AttributeOverride(name = "homework", column = @Column(name = "homework")),
            @AttributeOverride(name = "weeklyVerse", column = @Column(name = "weekly_verse")),
            @AttributeOverride(name = "monthlyVerse", column = @Column(name = "monthly_verse"))
    })
    private PerformancePoints points;
}
