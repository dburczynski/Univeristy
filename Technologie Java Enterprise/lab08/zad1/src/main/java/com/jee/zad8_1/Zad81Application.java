package com.jee.zad8_1;

import com.jee.zad8_1.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Zad81Application implements CommandLineRunner {


    private static final Logger log = LoggerFactory.getLogger(Zad81Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Zad81Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Selecting people");
        jdbcTemplate.query(
                "SELECT * from person",
                (rs, rowNum) -> new Person(rs.getInt("id"), rs.getString("firstName"), rs.getString("surname"))
        ).forEach(person -> log.info(person.toString()));
    }

}
