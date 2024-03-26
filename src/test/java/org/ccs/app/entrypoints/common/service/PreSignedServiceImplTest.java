package org.ccs.app.entrypoints.common.service;

import org.ccs.app.Application;
import org.ccs.app.config.AmazonCloudConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(classes = Application.class)
@Import({AmazonCloudConfig.class})
class PreSignedServiceImplTest {

    @Autowired
    private PreSignedService preSignedService;

    @Test
    void generateTest() {

        preSignedService.generate("temp/20231225/first");
    }
}