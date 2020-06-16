package com.jee.zad8_1.controller;

import com.jee.zad8_1.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String home(Model model) {
        ArrayList<Person> pm = new ArrayList<>();
        jdbcTemplate.query("SELECT * from person",
                (rs, rowNum) -> new Person(rs.getInt("id"), rs.getString("firstName"), rs.getString("surname"))
        ).forEach(person -> pm.add(person));
        model.addAttribute("persons", pm);
        return "home";
    }

}