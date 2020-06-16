package com.example.lab3_2.domain;

public class Dziecko extends Person{
    private Ojciec ojciec;
    private Matka matka;

    public Dziecko(String name, String lastName, int yob) {
        super(name,lastName,yob);

    }

    public Ojciec getOjciec() { return ojciec;}
    public void setOjciec(Ojciec ojciec ) {
        this.ojciec = ojciec; }
    public Matka getMatka() { return matka;}
    public void setMatka(Matka matka){
        this.matka = matka;
    }

    @Override
    public String toString() {
        try {
            return super.toString()+" Matka: "+matka.getName()+", Ojciec: "+ojciec.getName();
        }
        catch (Exception e) {
            try {
                return super.toString()+" Matka: "+matka.getName();
            }
            catch (Exception e2) {
                try {
                    return super.toString()+" Ojciec: "+ojciec.getName();
                }
                catch (Exception e3) {
                    return super.toString()+" Brak rodziow";

                }

            }

        }
    }

}
