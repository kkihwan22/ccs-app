package org.ccs.app.entrypoints.common.controller;

import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.common.service.MessageProducerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProducerRestController {

    private final MessageProducerService messageProducerService;

    @RequestMapping("/publish")
    public String publish(String message) {
        messageProducerService.send(message);
        return "published a message : " + message;
    }

    @RequestMapping("/publish/callback")
    public String publishWithCallback(String message) {
        messageProducerService.sendWithCallback(message);
        return "published a message : " + message;
    }
}
