package com.Hospital_Management.controller;


import java.time.DayOfWeek;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/template1")
    public String temp() {
        return "template1";
    }
    @RequestMapping("/")
    public String index() {
    	
        return "index";
    }
   
}
