package org.ccs.app.entrypoints.health.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HealthRestController.class)
class HealthRestControllerTest {
    private final static Logger log = LoggerFactory.getLogger(HealthRestControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCheckHealth() throws Exception {
        // 요청을 보내고 응답을 확인하는 테스트입니다.
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", "success");
        responseBody.put("service", "css-service");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(responseBody);
        log.debug(jsonContent);
        mockMvc.perform(get("/_health")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonContent))
                .andDo(print());
    }
}