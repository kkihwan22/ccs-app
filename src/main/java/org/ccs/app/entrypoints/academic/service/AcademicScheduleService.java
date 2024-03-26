package org.ccs.app.entrypoints.academic.service;

import org.ccs.app.entrypoints.academic.model.CreateAcademicScheduleRequest;

import java.time.LocalDate;
import java.util.List;

public interface AcademicScheduleService {

    List<LocalDate> generateAcademicSchedules(CreateAcademicScheduleRequest request);
}
