package com.example.lab4_3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("welcome")
public class WelcomeController {
    @RequestMapping(value = "")
    public String welcome(@RequestParam(name="name",required = false,defaultValue = "Swiecie") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }
}
