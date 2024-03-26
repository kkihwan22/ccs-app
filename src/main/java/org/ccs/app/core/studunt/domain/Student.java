package org.ccs.app.core.studunt.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ccs.app.core.user.domain.User;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "student")
@Getter @Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User student;

    // Audit 분리
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
