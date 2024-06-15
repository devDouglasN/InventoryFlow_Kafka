package com.douglas.springkafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PeopleProducer {

    private final String topicName;
    private final KafkaTemplate<String, People> kafkaTemplate;


    public PeopleProducer(@Value("${topic.name}") String topicName, KafkaTemplate<String, People> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage (People people) {
        kafkaTemplate.send(topicName.people).addCallBack(
                sucess -> log.info("Mensagem enviada com sucesso!"),
                sucess -> log.info("Falha ao enviar mensagem!")
        );
    }
}
