package com.example.lab3_2.service;

import com.example.lab3_2.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class RodzinaServiceConfig {
    @Bean
    public Ojciec ojciec() { return new Ojciec("Jan","Nowak",1973);}
    @Bean
    public Matka matka() { return new Matka("Alicja","Nowak",1975);}
    @Bean
    public Dziecko dziecko() { return new Dziecko("Andrzej","Nowak",1999); }
    @Bean
    public  Rodzina rodzina() {return new Rodzina();}
}
