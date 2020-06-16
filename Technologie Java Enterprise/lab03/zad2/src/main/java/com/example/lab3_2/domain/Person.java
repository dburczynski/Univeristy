package com.example.lab3_2.domain;

public class Person {
    private String name;
    private String lastName;
    private int yob;

    public Person() { System.out.println("Creating person" + this);}

    public Person(String name, String lastName, int yob) {
        this.name = name;
        this.lastName = lastName;
        this.yob = yob;
        System.out.println("Creating person" + this);
    }

    public String getName() { return  name;}
    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName;}
    public void setLastName(String lastName) { this.lastName = lastName;}

    public int getYob() { return yob;}
    public void setYob(int yob) { this.yob = yob;}

    @Override
    public String toString() {
        return "Person{"+"name='"+name+"\'"+", surname='"+lastName+"\'"+
                ", yob="+yob;
    }
}
