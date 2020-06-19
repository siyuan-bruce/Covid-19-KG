package com.ml.kg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

    @GetMapping("")
    public String demo(){

        return "demo";
    }


}
