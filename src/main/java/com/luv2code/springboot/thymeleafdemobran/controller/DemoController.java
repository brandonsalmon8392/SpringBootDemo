package com.luv2code.springboot.thymeleafdemobran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model themodel) {
        themodel.addAttribute("theDate", "02-18-2020");
        return "hello";
    }
    @RequestMapping("/tada")
    public String tadaShow() {
        return "tada";
    }

    @GetMapping("/page3")
    public String passPage3() {
        return "page3";
    }

    @GetMapping("/input")
    public String passInput() { return "input"; }

    @GetMapping("/editMenu")
    public String passEditMenu(RequestParam id, Model theModel) {
        theModel.addAttribute("id", id);
        return "editMenu";
    }

    @GetMapping("/login")
    public String login() {
        return"login";
    }
}


