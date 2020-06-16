package com.jee.zad8_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Zad82Application {

    public static void main(String[] args) {
        SpringApplication.run(Zad82Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
}
