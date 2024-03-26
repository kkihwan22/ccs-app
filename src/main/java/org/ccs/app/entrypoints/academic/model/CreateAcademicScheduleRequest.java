package org.ccs.app.entrypoints.academic.model;

import jakarta.validation.constraints.Min;

public record CreateAcademicScheduleRequest(@Min(value = 2020L) Integer targetDate) {
}
