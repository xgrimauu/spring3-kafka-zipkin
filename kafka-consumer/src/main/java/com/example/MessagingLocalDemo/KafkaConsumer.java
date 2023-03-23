package com.example.MessagingLocalDemo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = KafkaTopics.USER_CREATED)
    public void onMessageReceived(String userInfo) {
        log.info(userInfo);
    }
}
