package com.boardvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardVueApplication.class, args);
    }

}
