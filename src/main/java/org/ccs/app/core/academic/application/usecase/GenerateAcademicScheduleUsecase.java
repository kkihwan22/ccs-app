package org.ccs.app.core.academic.application.usecase;

import java.time.LocalDate;
import java.util.List;

public interface GenerateAcademicScheduleUsecase {


    List<LocalDate> generate(Integer targetYear);

}
