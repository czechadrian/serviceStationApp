package com.servicecompany.agh.controller;


import com.servicecompany.agh.owner.Owner;
import com.servicecompany.agh.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/owners")
public class OwnerController {


    private final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public Collection<Owner> getAllCars() {
        return ownerService.getAllOwners();
    }

    @GetMapping
    public Owner getCarById(@PathVariable("id") int id) {
        return ownerService.getOwnerById(id);
    }

}
