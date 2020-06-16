package com.jee.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class JsonController {

    private CustomerRepository cr;

    @Autowired
    public JsonController(CustomerRepository cr) {
        this.cr = cr;
    }

    @GetMapping("/create")
    public ResponseEntity<Customer> createShowPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("money") Double money) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setMoney(money);
        customer.setDate(new Date(Calendar.getInstance().getTimeInMillis()));

        cr.save(customer);

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

}
