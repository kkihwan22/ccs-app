package org.ccs.app.core.share.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter @ToString
public class BatchBetween extends BaseBetween {

    public BatchBetween(LocalDateTime startedAt, LocalDateTime endedAt) {
        super(startedAt, endedAt);
    }

    public BatchBetween(LocalDateTime basedDateTime) {
        this(basedDateTime.truncatedTo(ChronoUnit.DAYS).minusMinutes(10L), basedDateTime.minusMinutes(10L));
    }

    public BatchBetween() {
        this(LocalDateTime.now());
    }
}