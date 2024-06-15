package com.douglas.springkafka.dtos;

import java.util.List;

public record PeopleDTO(

        String name,
        String cpf,

        List<String> books

    ) {
}
