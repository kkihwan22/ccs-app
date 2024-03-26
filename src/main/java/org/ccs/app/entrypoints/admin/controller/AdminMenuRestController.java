package org.ccs.app.entrypoints.admin.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.admin.model.AdminMenuCreateRequest;
import org.ccs.app.entrypoints.admin.model.AdminMenuResponse;
import org.ccs.app.entrypoints.admin.service.AdminMenuService;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdminMenuRestController implements BaseRestController {
    private final Logger log = LoggerFactory.getLogger(AdminMenuRestController.class);
    private final AdminMenuService adminMenuService;

    // FIXME: response 변경
    @PostMapping("/admin/v1/menus")
    public ContentBody<AdminMenuResponse> createRootMenu(@RequestBody @Valid AdminMenuCreateRequest request, BindingResult bindingResult) {
        hasError(bindingResult);
        AdminMenuResponse response = adminMenuService.createMenu(request);
        log.debug("[createMenu] response : {}", response);
        return ResponseFactory.success(response);
    }
}
