package com.example.MessagingLocalDemo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessagingLocalDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingLocalDemoApplication.class, args);
	}


	@Bean
	public NewTopic topic() {
		return TopicBuilder.name(KafkaTopics.USER_CREATED)
				.partitions(10)
				.replicas(1)
				.build();
	}

}
