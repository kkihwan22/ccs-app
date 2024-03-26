package org.ccs.app.entrypoints.academic.controller;

import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.academic.model.CreateAcademicScheduleRequest;
import org.ccs.app.entrypoints.academic.service.AcademicScheduleService;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AcademicScheduleRestController implements BaseRestController {
    private static final Logger log = LoggerFactory.getLogger(AcademicScheduleRestController.class);
    private final AcademicScheduleService academicScheduleService;

    @PostMapping("/api/v1/academics/schedules")
    public ContentBody<List<LocalDate>> generateAcademicSchedules(
            @RequestBody CreateAcademicScheduleRequest request,
            BindingResult bindingResult) {

        hasError(bindingResult);
        List<LocalDate> results = academicScheduleService.generateAcademicSchedules(request);
        log.debug("results: {}");

        return ResponseFactory.success(results);
    }

}
