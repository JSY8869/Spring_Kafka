package spr.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
@Slf4j
public class ProducerContorller {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic myTopic1;
    private final NewTopic myTopic2;

    @GetMapping("/publish/mytopic1")
    public String publishSpringTopic1() {
        String message = "publish message to my_topic_1 " + UUID.randomUUID();

        kafkaTemplate.send(myTopic1.name(), message);

        return "done";
    }
    @GetMapping("/publish/mytopic2")
    public String publishSpringTopic2() {
        String message = "publish message to my_topic_2 " + UUID.randomUUID();

        kafkaTemplate.send(myTopic2.name(), message);

        return "done";
    }
}
