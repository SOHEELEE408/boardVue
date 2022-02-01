package com.boardvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@EnableJdbcAuditing
@SpringBootApplication
public class BoardVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardVueApplication.class, args);
    }

}
