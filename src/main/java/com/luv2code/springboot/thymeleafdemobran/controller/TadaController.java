package com.luv2code.springboot.thymeleafdemobran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TadaController {

    @RequestMapping("/tada")
    public String tadaShow() {
        return "tada";
    }
}
