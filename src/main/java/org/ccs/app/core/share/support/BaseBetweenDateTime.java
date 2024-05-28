package org.ccs.app.core.share.support;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @ToString
public abstract class BaseBetweenDateTime {

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    protected BaseBetweenDateTime(LocalDateTime startedAt, LocalDateTime endedAt) {
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }
}
