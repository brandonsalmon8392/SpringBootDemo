package com.luv2code.springboot.thymeleafdemobran.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class EmployeeController {
    Random rand = new Random();

    @Autowired
    EmployeeRepository repo;

    @GetMapping("/findall")
    public String findAll(Model theModel) {
        theModel.addAttribute("employees", repo.findAll());
        return "employees";
    }
    @GetMapping("/manage")
    public String manage(Model theModel) {
        theModel.addAttribute("employees", repo.findAll());
        return "manage";}

    @GetMapping("/findEmp")
    public String findEmployee(Model theModel, @RequestParam long id) {
        theModel.addAttribute("employee", repo.findById(id));
        return "editMenu";
    }

    @GetMapping("/searchfirst")
    public String search(Model theModel, @RequestParam String name) {
        theModel.addAttribute("resultEmployees", repo.findByFirstName(name));
        return"employeesSearch";
    }


    @GetMapping("/create")
    public String addEmployee(Model theModel, @RequestParam String fName, @RequestParam String lName, @RequestParam String email) {
        long newId = rand.nextInt(1000000);
        while(newId < 0 && newId > 1000000) {
            newId = rand.nextInt(1000000);
        }
        Employee newEmployee = new Employee(newId, fName, lName, email);

        repo.save(newEmployee);
        theModel.addAttribute("employees", repo.findAll());
        return "employees";
    }

    @GetMapping("/remove")
    @Transactional
    public String removeEmployee(@RequestParam long id) {
        repo.deleteEmployeeById(id);
        return "redirect:/findall";
    }

    @GetMapping("/edit")
    @Modifying
    @Transactional
    public String editEmployee(@RequestParam String fName, @RequestParam String lName, @RequestParam String email, @RequestParam long id) {
        repo.setEmployeeInfoById(fName, lName, email, id);

        return "redirect:/manage";
    }

}
