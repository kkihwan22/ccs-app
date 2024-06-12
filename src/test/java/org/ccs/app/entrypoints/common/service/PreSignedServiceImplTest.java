package org.ccs.app.entrypoints.common.service;

import org.ccs.app.Application;
import org.ccs.app.config.AmazonCloudConfig;
import org.ccs.app.entrypoints.common.model.FileDTO.PreSignedGenerateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(classes = Application.class)
@Import({AmazonCloudConfig.class})
class PreSignedServiceImplTest {

    @Autowired
    private FileService fileService;

    @Test
    void generateTest() {
        PreSignedGenerateRequest request = new PreSignedGenerateRequest("");
        fileService.generatePreSignedUrl(request);
    }
}