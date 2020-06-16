package com.example.lab4_3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("form")
public class FormController {
    @RequestMapping(value = "")
    public String welcome() {
        return "form";
    }
}
