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
import java.util.Collection;

@RestController
@RequestMapping("/manager")
public class ManagerController {


    private final Logger LOGGER = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public Collection<AbstractEmployee> getAllManagers() {
        return employeeService.getAllManagers();
    }
}
