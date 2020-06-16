package com.jee.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerPageableRepository customerPageableRepository;
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

    @GetMapping("/pageableTest")
    public String pageable() {
        Pageable firstPageTwoElements = PageRequest.of(0,2);
        Page<Customer> allCustomers = customerPageableRepository.findAll(firstPageTwoElements);
        log.info(allCustomers.toString());
        return "redirect:/create";
    }
}
