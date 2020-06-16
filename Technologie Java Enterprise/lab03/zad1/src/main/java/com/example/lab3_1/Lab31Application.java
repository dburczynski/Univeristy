package com.example.lab3_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import com.example.lab3_1.domain.Person;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Lab31Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Lab31Application.class, args);

    Person person = (Person) context.getBean("prezes");

		System.out.println(person.getName());

	}

}
