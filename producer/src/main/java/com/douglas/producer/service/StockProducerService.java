package com.douglas.producer.service;

import com.douglas.producer.dto.StockDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

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
        ListenableFuture<SendResult<String, StockDTO>> future = (ListenableFuture<SendResult<String, StockDTO>>) kafkaTemplate.send(topic, stockDTO);
        future.addCallback(new ListenableFutureCallback<SendResult<String, StockDTO>>() {
            @Override
            public void onSuccess(SendResult<String, StockDTO> result) {
                logger.info("Message send" + result.getProducerRecord().value());
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.info("Message failure" + ex.getMessage());
            }
        });
    }
}
