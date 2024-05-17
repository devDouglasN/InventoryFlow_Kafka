package com.douglas.consumer.consumer;

import com.douglas.consumer.dto.StockDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumerService {

    private static final Logger log = LoggerFactory.getLogger(StockConsumerService.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}",
            containerFactory = "stockKafkaListenerContainerFactory")
    public void listenTopicStock(ConsumerRecord<String, StockDTO> record) {
        log.info("Received Message" + record.partition());
        log.info("Received Message" + record.value());
    }
}
