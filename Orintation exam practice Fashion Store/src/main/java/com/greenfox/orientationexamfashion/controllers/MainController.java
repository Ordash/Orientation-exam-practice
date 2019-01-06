package com.greenfox.orientationexamfashion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/",""})
    public String warehouse(){
        return "redirect:/warehouse";
    }

}
