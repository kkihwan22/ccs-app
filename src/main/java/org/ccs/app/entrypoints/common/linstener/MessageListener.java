package org.ccs.app.entrypoints.common.linstener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    private static final String TOPIC_NAME = "topic";

    @KafkaListener(topics = TOPIC_NAME)
    public void listenMessage(String message) {
        try {
            System.out.println(">>>" + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
