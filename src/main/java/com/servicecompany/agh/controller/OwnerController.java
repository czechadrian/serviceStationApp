package com.servicecompany.agh.controller;


import com.servicecompany.agh.owner.Owner;
import com.servicecompany.agh.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public Owner getCarById(@PathVariable("id") int id) {
        return ownerService.getOwnerById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCarById(@PathVariable("id") int id){
        ownerService.deleteOwnerById(id);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Owner owner, @PathVariable("id") int id){
        ownerService.updateOwnerById(owner,id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertCar(@RequestBody Owner owner){
        ownerService.insertOwnerToDb(owner);
    }

}
