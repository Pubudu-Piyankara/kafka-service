package com.kafka.kafka_schema_registry.consumer;

import com.kafka.kafka_schema_registry.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {

    // listen to topic
    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, Order> consumerRecord) {
        String key = consumerRecord.key();
        Order order = consumerRecord.value();
        log.info("Avro message received for key : " + key + " value : " + order.toString());

    }
}
