package org.ccs.app.core.academic.domain;

import jakarta.persistence.Embeddable;

/**
 * Entity가 아니라 VO입니다.
 * @@Embeddable: 해당 클래스가 다른 엔티티에 포함될 수 있음
 */

@Embeddable
public class PerformancePoints {
    private Integer attendance;
    private Integer homework;
    private Integer weeklyVerse;
    private Integer monthlyVerse;
}
