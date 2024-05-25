package com.douglas.springkafka.domain;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String stockItem;
    private Integer quantity;

    @ManyToOne
    private Person person;
}
