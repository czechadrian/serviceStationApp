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
public class LogisticianController {


    private final Logger LOGGER = LoggerFactory.getLogger(LogisticianController.class);

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/employees/logisticians")
    public Collection<AbstractEmployee> getAllLogisticians() {
        LOGGER.info("Request to get all logisticians");
        return employeeService.getAllLogisticians();
    }

}