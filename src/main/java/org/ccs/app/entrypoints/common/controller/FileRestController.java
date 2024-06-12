package org.ccs.app.entrypoints.common.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.common.model.FileDTO.PreSignedGenerateRequest;
import org.ccs.app.entrypoints.common.model.FileDTO.PreSignedResponse;
import org.ccs.app.entrypoints.common.service.FileService;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FileRestController implements BaseRestController {
    private final static Logger log = LoggerFactory.getLogger(FileRestController.class);

    private final FileService fileService;

    @PutMapping("/presigned")
    public ContentBody<PreSignedResponse> preSigned(@RequestBody @Valid PreSignedGenerateRequest request, BindingResult bindingResult) {
        hasError(bindingResult);
        return ResponseFactory.ok(fileService.generatePreSignedUrl(request));
    }
}
