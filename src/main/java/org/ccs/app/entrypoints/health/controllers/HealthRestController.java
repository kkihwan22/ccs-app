package org.ccs.app.entrypoints.health.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthRestController {
    private final Logger LOG = LoggerFactory.getLogger(HealthRestController.class);

    @GetMapping("/_health")
    public Map<String,String> checkHealth() {
        LOG.info("[health] check.");
        final Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", "success");
        responseBody.put("service", "css-service");
        return responseBody;
    }
}
