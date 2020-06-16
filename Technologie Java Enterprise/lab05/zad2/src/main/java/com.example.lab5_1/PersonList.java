package com.example.lab5_1;

import com.example.lab5_1.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> peopleList;
    public PersonList(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    public List<Person> getPeopleList() {
        return this.peopleList;
    }

    public void setPeopleList(List<Person> peopleList) {
        this.peopleList = peopleList;
    }
}
