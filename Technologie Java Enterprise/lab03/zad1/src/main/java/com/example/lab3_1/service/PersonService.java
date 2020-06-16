package com.example.lab3_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.lab3_1.domain.Person;

@Service
public class PersonService {


  @Autowired
  @Qualifier("prezes")
  Person prezes;
  Person getPrezes () {return prezes;}

  @Autowired
  @Qualifier("wiceprezes")
  Person wicePrezes;
  Person getWicePrezes() {return  wicePrezes;}

  @Autowired
  @Qualifier("sekretarka")
  Person sekretarka;
  Person getSekretarka() {return sekretarka;}

}
