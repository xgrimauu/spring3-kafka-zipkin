package com.example.MessagingLocalDemo;

import lombok.Builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
public class UserInfo {

    private String name;
    private int age;
    private LocalDate registeredAt;

    public String toString() {
        return """
                {
                user: %s,
                age : %s,
                registeredAt: %s
                }
                """
                .formatted(this.name, this.age, registeredAt.format(DateTimeFormatter.ISO_DATE));
    }
}
