package com.servicecompany.agh.controller;


import com.servicecompany.agh.owner.Owner;
import com.servicecompany.agh.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Owner> getAllCars(){
        return ownerService.getAllOwners();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Owner getCarById(@PathVariable("id") int id){
        return ownerService.getOwnerById(id);
    }

}
