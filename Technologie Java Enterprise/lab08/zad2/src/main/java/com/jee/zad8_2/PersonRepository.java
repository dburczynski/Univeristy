package com.jee.zad8_2;

import com.jee.zad8_2.domain.Person;

public interface PersonRepository {

    Iterable<Person> findAll();

    Person findById(int id);

    void save(Person person);
}