package com.example.lab5_1.Controllers;

import com.example.lab5_1.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/create")
public class PersonController {

    private static List<Person> people = new ArrayList<Person>();

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
        people.add(person);
        log.info("Added Person to list "+person);
        log.info("Person created: " + person);
        return "redirect:/";
    }

    public static List<Person> getPeople() {
        return PersonController.people;
    }
}