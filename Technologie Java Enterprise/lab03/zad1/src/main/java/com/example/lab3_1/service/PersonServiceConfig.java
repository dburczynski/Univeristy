package com.example.lab3_1.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.lab3_1.domain.Person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Configuration
public class PersonServiceConfig {
  @Bean
  public Person prezes() { return new Person("Chrystal","Havoc","chavorc@yahoo.com","Mymm");}
  @Bean
  public Person wiceprezes() { return new Person("Halley","Gadaud","hgadaud9@sohu.com","Oyope");}
  @Bean
  public Person sekretarka() { return new Person("Kirbie","Wrettum","kwrettumj@slideshar.net","Browsetype");}

}
