package com.douglas.producer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDTO {

    private String id;
    private Integer amount;
    private String location;

}
