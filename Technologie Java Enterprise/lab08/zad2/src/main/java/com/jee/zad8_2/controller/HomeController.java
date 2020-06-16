package com.jee.zad8_2.controller;

import com.jee.zad8_2.JdbcPersonRepository;
import com.jee.zad8_2.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class HomeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private JdbcPersonRepository jpr;

    @Autowired
    public HomeController(JdbcPersonRepository jpr) {
        this.jpr = jpr;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("persons", jpr.findAll());
        return "person_all";
    }

    @GetMapping("/add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person_add";
    }

    @PostMapping("/add")
    public String addPersonError(@Valid Person person, Errors errors) {
        if (errors.hasErrors()) {
            return "person_add";
        }
        jpr.save(person);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String newFindPerson(Model model){
        model.addAttribute("person", new Person());
        return "person_search";
    }

    @PostMapping("/search")
    public String findPerson(Person person, Errors errors, Model model) {
        if(errors.hasErrors()){
            return "redirect:/search";
        }
        model.addAttribute("person", jpr.findById(person.getId()));
        return "person_search_answer";
    }
}
