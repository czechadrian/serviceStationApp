package com.servicecompany.agh.controller;


import com.servicecompany.agh.employees.Role;
import com.servicecompany.agh.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoleController {

    private final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/roles")
    Collection<Role> roles() { return roleService.getAllRoles(); }

    @GetMapping( value = "/role/{id}")
    ResponseEntity<?> getRoleById(@PathVariable("id") int id ) {
        Optional<Role> role = roleService.getRoleById(id);
        return role.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
