package com.servicecompany.agh.controller;

import com.servicecompany.agh.employees.AbstractEmployee;
import com.servicecompany.agh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/accountant")

public class AccountantController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public AbstractEmployee getEmployeeByUsername(Principal principal) {
        return employeeService.getEmployeeByUsername(principal.getName());
    }
}
