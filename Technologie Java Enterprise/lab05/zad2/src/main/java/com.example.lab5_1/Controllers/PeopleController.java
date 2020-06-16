package com.example.lab5_1.Controllers;

import com.example.lab5_1.Person;
import com.example.lab5_1.PersonList;
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
@RequestMapping("/show")
public class PeopleController {

    @GetMapping
    public String people(Model model){
        List<Person> p = new PersonList(PersonController.getPeople()).getPeopleList();
        model.addAttribute("people", p);
        return "peopleList";
    }

}