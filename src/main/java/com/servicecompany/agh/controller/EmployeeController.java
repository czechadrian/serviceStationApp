package com.servicecompany.agh.controller;


import com.servicecompany.agh.employees.AbstractEmployee;
import com.servicecompany.agh.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class EmployeeController {

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Collection<AbstractEmployee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public AbstractEmployee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }

}
