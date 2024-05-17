package com.douglas.producer.service;

import com.douglas.producer.dto.StockDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Service
public class StockProducerService {

    private static final Logger logger = LoggerFactory.getLogger(StockProducerService.class);
    private final String topic;
    private final KafkaTemplate<String, StockDTO> kafkaTemplate;

    public StockProducerService(@Value("${topic.name}") String topic, KafkaTemplate<String, StockDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(StockDTO stockDTO) {
        CompletableFuture<SendResult<String, StockDTO>> future = kafkaTemplate.send(topic, stockDTO);
        future.whenComplete(new BiConsumer<SendResult<String, StockDTO>, Throwable>() {
            @Override
            public void accept(SendResult<String, StockDTO> result, Throwable ex) {
                if (ex != null) {
                    logger.error("Message failure: " + ex.getMessage());
                } else {
                    logger.info("Message sent: " + result.getProducerRecord().value());
                }
            }
        });
    }
}
