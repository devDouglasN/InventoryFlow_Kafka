package com.douglas.springkafka.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String name;
    private String cpf;

    @OneToMany(mappedBy = "person")
    private List<Stock> stocks;
}
