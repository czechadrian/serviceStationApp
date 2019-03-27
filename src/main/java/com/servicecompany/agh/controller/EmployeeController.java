package com.servicecompany.agh.controller;


import com.servicecompany.agh.employees.AbstractEmployee;
import com.servicecompany.agh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AbstractEmployee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }

}
