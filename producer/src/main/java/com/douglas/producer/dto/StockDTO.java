package com.douglas.producer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDTO {

    private String id;
    private Integer amount;
    private String location;

    public StockDTO() {
    }

    public StockDTO(String id, Integer amount, String location) {
        this.id = id;
        this.amount = amount;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
