package com.nowgnodeel.boardbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardBeApplication.class, args);
    }

}
