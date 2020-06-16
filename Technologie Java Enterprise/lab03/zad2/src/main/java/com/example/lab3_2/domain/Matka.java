package com.example.lab3_2.domain;

import java.util.ArrayList;

public class Matka extends Person {
    private ArrayList<Dziecko> dzieci;
    public Matka(String name, String lastName, int yob) {
        super(name,lastName,yob);
        this.dzieci = new ArrayList<Dziecko>();
    }

    public ArrayList<Dziecko> getDzieci() {
        return dzieci;
    }
    public void setDzieci(Dziecko d) {
        dzieci.add(d);
    }

    @Override
    public String toString() {
        String text = " Jej Dzieci :";
        try {
            for (Person m : dzieci) {
                text += m.getName() + ", ";
            }
        }
        catch (Exception e) {
            text+= " Brak!";
        }
        return super.toString()+text;
    }
}
