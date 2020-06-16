package com.example.lab3_2;

import com.example.lab3_2.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;

@ImportResource("classpath:bean.xml")
@SpringBootApplication
public class Lab32Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab32Application.class, args);
        Ojciec o = (Ojciec) context.getBean("ojciec");
        Matka m = (Matka) context.getBean("matka");
        Dziecko d = (Dziecko) context.getBean("dziecko");

        o.setDzieci(d);
        m.setDzieci(d);
        d.setOjciec(o);
        d.setMatka(m);

        Rodzina r = (Rodzina) context.getBean("rodzina");
        ArrayList<Person> al = new ArrayList<>();
        al.add(o);
        al.add(m);
        al.add(d);
        r.setRodzina(al);
        System.out.println(r.toString());

        Rodzina r2 = (Rodzina) context.getBean("1");
        r2.toString();



    }


}
