package com.example.lab3_2.domain;

import java.util.ArrayList;

public class Rodzina {

    private ArrayList<Person> rodzina;

    public Rodzina() {
        System.out.println("Creating family!");
    }
    public  Rodzina(ArrayList<Person> rodzina) {
        this.rodzina = rodzina;
    }

    public ArrayList<Person> getRodzina() {return rodzina;}
    public void setRodzina(ArrayList<Person> rodzina) {this.rodzina = rodzina;}

    @Override
    public String toString() {
        String text = "Rodzina:\n";
        try {
            for (Person p : rodzina) {
                text += p.toString()+"\n";
            }
        }
        catch (Exception e) {
            text+=" Jest pusta!";
        }
        return text;
    }
}
