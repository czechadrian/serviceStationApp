package com.servicecompany.agh.controller;

import com.servicecompany.agh.employees.AbstractEmployee;
import com.servicecompany.agh.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/mechanic")

public class MechanicController {


    private final Logger LOGGER = LoggerFactory.getLogger(MechanicController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public AbstractEmployee getEmployeeByUsername(Principal principal) {
        return employeeService.getEmployeeByUsername(principal.getName());
    }
}
