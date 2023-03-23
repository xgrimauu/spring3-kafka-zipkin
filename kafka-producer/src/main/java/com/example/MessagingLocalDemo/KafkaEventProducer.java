package com.example.MessagingLocalDemo;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final Faker FAKER = new Faker();

    @Scheduled(fixedDelay = 1000)
    public void sendEvent() {
        UserInfo userInfo = generateRandomUserInfo();
        log.info("Sending message to Kafka");
        kafkaTemplate.send(KafkaTopics.USER_CREATED, userInfo.toString());
    }

    private UserInfo generateRandomUserInfo() {
        return UserInfo.builder()
                .name(FAKER.name().fullName())
                .age(FAKER.number().numberBetween(18, 99))
                .registeredAt(LocalDate.now())
                .build();
    }


}
