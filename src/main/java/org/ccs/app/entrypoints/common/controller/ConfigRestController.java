package org.ccs.app.entrypoints.common.controller;

import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.ccs.app.entrypoints.share.model.SuccessBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class ConfigRestController implements BaseRestController {

    @GetMapping("/client-key")
    public ContentBody<SuccessBody<String>> issuedClientKey() {
        return ResponseFactory.ok(new SuccessBody<>(UUID.randomUUID().toString()));
    }
}
