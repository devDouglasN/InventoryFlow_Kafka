package com.douglas.producer.controller;

import com.douglas.producer.dto.StockDTO;
import com.douglas.producer.service.StockProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockProducerService stockService;

    @PostMapping
    public ResponseEntity<StockDTO> create(@RequestBody StockDTO stockDTO) {
        StockDTO stock = StockDTO.builder().id(UUID.randomUUID().toString()).amount(stockDTO.getAmount()).location(stockDTO.getLocation()).build();
        stockService.send(stock);
        return  ResponseEntity.status(HttpStatus.CREATED).body(stock);
    }
}
