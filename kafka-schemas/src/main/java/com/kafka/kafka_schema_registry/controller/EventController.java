package com.kafka.kafka_schema_registry.controller;

import com.kafka.kafka_schema_registry.model.Order;
import com.kafka.kafka_schema_registry.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    private KafkaAvroProducer producer;

    @PostMapping("/order")
    public String sendMessage(@RequestBody Order order) {
        producer.send(order);
        return "message published !";
    }
}
