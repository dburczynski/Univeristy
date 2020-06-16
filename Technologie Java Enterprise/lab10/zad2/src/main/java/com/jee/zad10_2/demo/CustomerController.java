package com.jee.zad10_2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());

        return "create";
    }

    @PostMapping("/create")
    public String processCreateOrder(@Valid Customer customer, Errors errors) {
        if (errors.hasErrors()) {
            return "create";
        }
        customer.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers")
    public String customers(Model model) {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }
}
