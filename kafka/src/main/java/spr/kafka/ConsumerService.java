package spr.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(topics = "#{myTopic1.name}", groupId = "group1")
    public void consumeMyTopic1(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        log.info("[consume message]: {} from partition: {}", message, partition);
    }

    @KafkaListener(topics = "#{myTopic2.name}", groupId = "group1")
    public void consumeMyopic2(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition){
        log.info("[consume message]: {} from partition: {}", message, partition);
    }
}
