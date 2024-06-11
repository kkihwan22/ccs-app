package org.ccs.app.core.share.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @ToString
public abstract class BaseBetween {

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    protected BaseBetween(LocalDateTime startedAt, LocalDateTime endedAt) {
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }
}
