package com.douglas.springkafka.producer;

import br.com.springkafka.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class PeopleProducer {

    private final String topicName;
    private final KafkaTemplate<String, People> kafkaTemplate;

    public PeopleProducer(@Value("${topic.name}") String topicName, KafkaTemplate<String, People> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(People people) {
        kafkaTemplate.send(topicName, people).whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Mensagem enviada com sucesso para o offset {}", result.getRecordMetadata().offset());
            } else {
                log.error("Falha ao enviar mensagem", ex);
            }
        });
    }

}
