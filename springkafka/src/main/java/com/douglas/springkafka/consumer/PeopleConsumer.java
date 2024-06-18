package com.douglas.springkafka.consumer;

import br.com.springkafka.People;
import com.douglas.springkafka.domain.Stock;
import com.douglas.springkafka.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
public class PeopleConsumer {

    @Autowired
    private PeopleRepository peopleRepository;

    @KafkaListener(topics = "${topic.name}")
    public void consumer(ConsumerRecord<String, People> record, Acknowledgment ack) {

        log.info("Entrou no método consumer");

        var people = record.value();

        log.info("Mensagem consumida: " + people.toString());

        var peopleEntity = com.douglas.springkafka.domain.People.builder().build();

        peopleEntity.setId(people.getId().toString());
        peopleEntity.setCpf(people.getCpf().toString());
        peopleEntity.setName(people.getName().toString());
        peopleEntity.setStocks(people.getBooks().stream()
                .map(stock -> Stock.builder()
                        .people(peopleEntity)
                        .stockItem(stock.toString())
                        .build()).collect(Collectors.toList()));

        peopleRepository.save(peopleEntity);

        ack.acknowledge();
    }
}
