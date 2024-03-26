package org.ccs.app.core.academic.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.academic.application.usecase.GenerateAcademicScheduleUsecase;
import org.ccs.app.core.academic.domain.AcademicSchedule;
import org.ccs.app.core.academic.infra.repository.AcademicScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AcademicScheduleApplication implements GenerateAcademicScheduleUsecase {
    private final Logger log = LoggerFactory.getLogger(AcademicScheduleApplication.class);
    private final AcademicScheduleRepository academicScheduleRepository;


    @Override
    @Transactional
    public List<LocalDate>  generate(Integer targetYear) {
        LocalDate start = LocalDate.of(targetYear, 1, 1);
        LocalDate end = LocalDate.of(targetYear, 12, 31);

        List<LocalDate> schedules = new ArrayList<>();
        while (start.isBefore(end) || start.isEqual(end)) {
            if (start.getDayOfWeek() == DayOfWeek.SUNDAY) {
                schedules.add(start);

                AcademicSchedule schedule = AcademicSchedule.builder()
                        .year(targetYear)
                        .closed(false)
                        .reason(null)
                        .scheduleDate(start)
                        .build();

                academicScheduleRepository.save(schedule);
            }
            start = start.plusDays(1);
        }

        return schedules;
    }
}