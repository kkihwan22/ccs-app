package org.ccs.app.core.academic.domain;

import org.ccs.app.core.user.domain.User;

import java.time.LocalDateTime;

public class Teacher {
    private Long id;
    private User teacher;
    private Boolean head; // 정/부 구분
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
