package org.ccs.app.core.share.support;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter @ToString
public class BatchBetweenDateTime extends BaseBetweenDateTime {

    public BatchBetweenDateTime(LocalDateTime startedAt, LocalDateTime endedAt) {
        super(startedAt, endedAt);
    }

    public BatchBetweenDateTime(LocalDateTime basedDateTime) {
        this(basedDateTime.truncatedTo(ChronoUnit.DAYS).minusMinutes(10L), basedDateTime.minusMinutes(10L));
    }

    public BatchBetweenDateTime() {
        this(LocalDateTime.now());
    }
}