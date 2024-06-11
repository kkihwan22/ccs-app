package org.ccs.app.core.share.model;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Pattern;

public class BillBoardChartBatchBetween extends BaseBetween {
    private final static ZoneId ZONE_ID = ZoneId.of("US/Eastern");
    private final static String REGEX_DATE_FORMAT = "\\d{4}-\\d{2}-\\d{2}";
    private final static Pattern PATTERN = Pattern.compile(REGEX_DATE_FORMAT);
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static LocalDateTime getStartOfWeek(LocalDateTime applyDate) {
        return applyDate.minusDays(applyDate.getDayOfWeek().ordinal() + 6).toLocalDate().atStartOfDay();
    }

    private static LocalDateTime getEndOfWeek(LocalDateTime applyDate) {
        return BillBoardChartBatchBetween.getStartOfWeek(applyDate).plusDays(6).with(LocalTime.MAX);
    }

    public BillBoardChartBatchBetween(LocalDateTime applyDate) {
        super(BillBoardChartBatchBetween.getStartOfWeek(applyDate), BillBoardChartBatchBetween.getEndOfWeek(applyDate));
    }

    public BillBoardChartBatchBetween() {
        this(ZonedDateTime.now(ZONE_ID).toLocalDateTime());
    }

    public static BillBoardChartBatchBetween of(String applyDate) {
        if (Objects.nonNull(applyDate) && PATTERN.matcher(applyDate).matches()) {
            return new BillBoardChartBatchBetween(LocalDateTime.of(LocalDate.parse(applyDate, FORMATTER), LocalTime.now(ZONE_ID)));
        }

        return new BillBoardChartBatchBetween();
    }
}