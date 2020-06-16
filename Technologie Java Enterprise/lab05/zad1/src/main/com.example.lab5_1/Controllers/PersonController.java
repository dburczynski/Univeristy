package com.example.lab5_1.Controllers;

import com.example.lab5_1.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/create")
public class PersonController {

    @GetMapping
    public String personForm(Model model){
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping
    public String processOrder(@Valid Person person, Errors errors){
        if(errors.hasErrors()){
            return "personForm";
        }

        log.info("Person created: " + person);
        return "redirect:/";
    }
}