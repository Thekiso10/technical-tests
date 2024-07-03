package com.mca.infrastructure;

import com.mca.service.VideoGameEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageConsumer<K extends String, V extends String> {

    private final VideoGameEventService videoGameEventService;

    @KafkaListener(topics = "${topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen2(String message, Acknowledgment acknowledgment) {
        log.info("Process Stock message from Kafka: " + message);
        videoGameEventService.updateStockFromKafka(message);
        acknowledgment.acknowledge();
    }

}
