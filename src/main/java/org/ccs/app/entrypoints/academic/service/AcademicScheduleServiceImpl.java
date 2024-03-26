package org.ccs.app.entrypoints.academic.service;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.academic.application.usecase.GenerateAcademicScheduleUsecase;
import org.ccs.app.entrypoints.academic.model.CreateAcademicScheduleRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AcademicScheduleServiceImpl implements AcademicScheduleService {
    private final GenerateAcademicScheduleUsecase generateAcademicScheduleUsecase;

    @Override
    public List<LocalDate> generateAcademicSchedules(CreateAcademicScheduleRequest request) {
        return generateAcademicScheduleUsecase.generate(request.targetDate());
    }
}
