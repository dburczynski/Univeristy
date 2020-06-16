package com.example.lab3_2.service;

import com.example.lab3_2.domain.Dziecko;
import com.example.lab3_2.domain.Matka;
import com.example.lab3_2.domain.Ojciec;
import com.example.lab3_2.domain.Rodzina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class RodzinaService {

    @Autowired
    @Qualifier("Rodzina Nowakow")
    Rodzina nowak;
    Rodzina getNowak() {return  nowak;}

    @Autowired
    @Qualifier("ojciec")
    Ojciec o;
    Ojciec getO() { return o;}

    @Autowired
    @Qualifier("matka")
    Matka m;
    Matka getM() {return m;}

    @Autowired
    @Qualifier("dziecko")
    Dziecko d;
    Dziecko getD(){return d;}
//
//    @Autowired
//    @Qualifier("Rodzina Kowalskich")
//    Rodzina kowalski;
//    Rodzina getKowalski() {return  kowalski;}



}
