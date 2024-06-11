package org.ccs.app.entrypoints.common.controller;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.common.application.usecase.clientproperty.ClientPropertyCreateUsecase;
import org.ccs.app.core.common.application.usecase.clientproperty.ClientPropertyCreateUsecase.CreateParameter;
import org.ccs.app.entrypoints.common.model.ClientPropertyDTO;
import org.ccs.app.entrypoints.common.model.ClientPropertyDTO.CreateRequest;
import org.ccs.app.entrypoints.common.model.ClientPropertyDTO.DefaultResponse;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdminClientPropertyRestController implements BaseRestController {
    private final static Logger log = LoggerFactory.getLogger(AdminClientPropertyRestController.class);
    private final ClientPropertyCreateUsecase clientPropertyCreateUsecase;

    @PostMapping("/admin/v1/commons/client-property")
    public DefaultResponse createClientProperty(@RequestBody CreateRequest request) {
        Long id = clientPropertyCreateUsecase.create(new CreateParameter(
                request.key(),
                request.propertyValue(),
                request.usingIos(),
                request.usingAos(),
                request.usingWeb()));

        return ResponseFactory.success(ClientPropertyDTO.DefaultResponse(id));
    }
}
