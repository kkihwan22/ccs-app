package org.ccs.app.entrypoints.common.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class MessageProducerService {
    private final static String TOPIC_NAME = "topic";
    private final KafkaTemplate kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
    }

    public void sendWithCallback(String message) {
        CompletableFuture<SendResult<String,String>> future = kafkaTemplate.send(TOPIC_NAME, message);

        future.thenAccept(result -> {
            System.out.println("Sent " + message + " offset:" + result.getRecordMetadata().offset());
        }).exceptionally(ex -> {
            System.out.println("Failed " + message + " due to : " + ex.getMessage());
            return null;
        });
    }
}
