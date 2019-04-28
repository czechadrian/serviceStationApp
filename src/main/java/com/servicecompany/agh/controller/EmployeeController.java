package com.servicecompany.agh.controller;


import com.servicecompany.agh.employees.AbstractEmployee;
import com.servicecompany.agh.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);


    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/user")
    public Collection<AbstractEmployee> getAllManagers() {
        LOGGER.info("Tutaj");
        return employeeService.getAllManagers();
    }


    @GetMapping(value = "/employees")
    Collection<AbstractEmployee> getAllEmployees() {
        LOGGER.info("Request to get all employees");
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/login")
    public AbstractEmployee currentUserName(Principal principal) {
        return employeeService.getEmployeeByLogin(principal.getName());
    }

    @GetMapping(value = "/employee/{id}")
    ResponseEntity<?> getEmployeeById(@PathVariable("id") int id) {
        LOGGER.info("Request to get employee with id: {}", id);
        Optional<AbstractEmployee> employee = employeeService.getEmployeeById(id);
        return employee.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/byLogin/{login}")
    public AbstractEmployee getEmployeeByLogin(@PathVariable("login") String login) {
        return employeeService.getEmployeeByLogin(login);
    }

    @DeleteMapping(value = "/employee/{id}")
    ResponseEntity<?> deleteEmployeeById(@PathVariable("id") int id) {
        LOGGER.info("Request to delete employee: {}", id);
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AbstractEmployee> updateEmployeeById(@RequestBody AbstractEmployee abstractEmployee) {
        LOGGER.info("Request to update employee: {}", abstractEmployee);
        employeeService.updateEmployeeById(abstractEmployee);
        return ResponseEntity.ok().body(abstractEmployee);
    }

    @PostMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AbstractEmployee> insertEmployeeToDb(@Valid @RequestBody AbstractEmployee abstractEmployee) throws URISyntaxException {
        LOGGER.info("Request to create employee: {}", abstractEmployee);
        employeeService.insertEmployeeToDb(abstractEmployee);
        return ResponseEntity.created(new URI("/api/employee" + abstractEmployee.getId())).body(abstractEmployee);
    }
}

