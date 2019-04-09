package com.servicecompany.agh.controller;


import com.servicecompany.agh.employees.AbstractEmployee;
import com.servicecompany.agh.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("users")
public class EmployeeController {

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Collection<AbstractEmployee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public AbstractEmployee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployeeById(@PathVariable("id") int id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody AbstractEmployee abstractEmployee, int id) {
        employeeService.updateEmployeeById(abstractEmployee, id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEmployee(@RequestBody AbstractEmployee abstractEmployee) {
        employeeService.insertEmployeeToDb(abstractEmployee);
    }
}

