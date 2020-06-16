package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Calendar;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            Date date = new Date(Calendar.getInstance().getTimeInMillis());
            Customer c = new Customer();
            c.setFirstName("Jack");
            c.setLastName("Bauer");
            c.setMoney(20.0);
            c.setDate(date);
            repository.save(c);
            c = new Customer();
            c.setFirstName("Chloe");
            c.setLastName("O'Brian");
            c.setMoney(22.0);
            c.setDate(date);
            repository.save(c);
            c = new Customer();
            c.setFirstName("Kim");
            c.setLastName("Bauer");
            c.setMoney(22.0);
            c.setDate(date);
            repository.save(c);
            c = new Customer();
            c.setFirstName("David");
            c.setLastName("Palmer");
            c.setMoney(22.0);
            c.setDate(date);
            repository.save(c);
            c = new Customer();
            c.setFirstName("Michelle");
            c.setLastName("Dessler");
            c.setMoney(20.0);
            c.setDate(date);
            repository.save(c);

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");

            log.info("Customer found with findByMoney(20.0):");
            log.info("--------------------------------------------");
            repository.findByMoney(20.0).forEach(customer2 -> {
                log.info(customer2.toString());
            });
            log.info("");

            log.info("Customer found with findByDate(date):");
            log.info("--------------------------------------------");
            repository.findByDate(date).forEach(customer3 -> {
                log.info(customer3.toString());
            });
            log.info("");
        };
    }

}
