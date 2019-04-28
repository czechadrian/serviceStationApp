package com.servicecompany.agh.controller;

import com.servicecompany.agh.employees.AbstractEmployee;
import com.servicecompany.agh.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ManagerController {


    private final Logger LOGGER = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees/managers")
    public Collection<AbstractEmployee> getAllManagers() {
        LOGGER.info("Request to get all managers");
        return employeeService.getAllManagers();
    }
}
