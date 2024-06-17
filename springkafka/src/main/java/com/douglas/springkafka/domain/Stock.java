package com.douglas.springkafka.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Stock {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    private String stockItem;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private People people;
}
