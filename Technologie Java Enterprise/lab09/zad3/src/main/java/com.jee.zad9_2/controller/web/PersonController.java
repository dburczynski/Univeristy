package com.jee.zad9_2.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jee.zad9_2.domain.Person;
import com.jee.zad9_2.service.PersonManager;

@Controller("personwebcontroller")
public class PersonController {

//  private PersonManager pm;
//
//  @Autowired
//  public PersonController(PersonManager pm) {
//    this.pm = pm;
//  }
//
//  @GetMapping("/person")
//  public String home(Model model){
//    model.addAttribute("persons", pm.getAllPersons());
//    return "person-all";
//  }
//
//  @GetMapping("/person/new")
//  public String newPerson(Model model){
//    model.addAttribute("person", new Person());
//    return "person-add";
//  }
//
//  @GetMapping("/person/delete/{id}")
//  public String deletePerson(@PathVariable("id") String id, Model model) {
//    pm.remove(id);
//    model.addAttribute("persons", pm.getAllPersons());
//    return "person-all";
//  }
//
//  @PostMapping("/person/add")
//  public String addPerson(Person person, Model model) {
//    pm.addPerson(person);
//    model.addAttribute("persons", pm.getAllPersons());
//    return "person-all";
//  }

}
