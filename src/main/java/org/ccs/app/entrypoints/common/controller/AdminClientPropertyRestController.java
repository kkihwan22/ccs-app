package org.ccs.app.entrypoints.common.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ccs.app.core.common.application.usecase.clientproperty.ClientPropertyCreateUsecase;
import org.ccs.app.core.common.application.usecase.clientproperty.ClientPropertyCreateUsecase.CreateParameter;
import org.ccs.app.core.common.application.usecase.clientproperty.ClientPropertyUpdateUsecase;
import org.ccs.app.entrypoints.common.model.ClientPropertyDTO.CreateRequest;
import org.ccs.app.entrypoints.common.model.ClientPropertyDTO.Response;
import org.ccs.app.entrypoints.common.model.ClientPropertyDTO.UpdateRequest;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.ccs.app.entrypoints.share.model.PageBodyWrapper;
import org.ccs.app.entrypoints.share.model.SuccessBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ccs.app.core.common.application.usecase.clientproperty.ClientPropertyUpdateUsecase.UpdateParameter;

@RequiredArgsConstructor
@RestController
public class AdminClientPropertyRestController implements BaseRestController {
    private final static Logger log = LoggerFactory.getLogger(AdminClientPropertyRestController.class);
    private final ClientPropertyCreateUsecase clientPropertyCreateUsecase;
    private final ClientPropertyUpdateUsecase clientPropertyUpdateUsecase;

    @GetMapping("/admin/v1/commons/client-property")
    public PageBodyWrapper<List<Response>> searchForClientProperty() {
        return ResponseFactory.pagingBy(List.of(), 0L, Boolean.FALSE, Boolean.FALSE);
    }

    @GetMapping("/admin/v1/commons/client-property/{id}")
    public ContentBody<Response> getClientProperty(@PathVariable Long id) {
        return ResponseFactory.ok(null);
    }

    @PostMapping("/admin/v1/commons/client-property")
    public ContentBody<SuccessBody<Long>> createClientProperty(@Valid @RequestBody CreateRequest request, BindingResult bindingResult) {
        hasError(bindingResult);
        Long id = clientPropertyCreateUsecase.create(new CreateParameter(
                request.key(),
                request.propertyValue(),
                request.usingIos(),
                request.usingAos(),
                request.usingWeb()));

        return ResponseFactory.success(id);
    }

    @PutMapping("/admin/v1/commons/client-property/{id}")
    public ContentBody<SuccessBody<Long>> updateClientProperty(
            @PathVariable Long id,
            @Valid @RequestBody UpdateRequest request, BindingResult bindingResult) {
        hasError(bindingResult);
        clientPropertyUpdateUsecase.update(
                id, new UpdateParameter(request.propertyValue(), request.usingIos(), request.usingAos(), request.usingWeb()));
        return ResponseFactory.success(id);
    }
}