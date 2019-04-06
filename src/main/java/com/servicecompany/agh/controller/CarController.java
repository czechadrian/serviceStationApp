package com.servicecompany.agh.controller;


import com.servicecompany.agh.car.Car;
import com.servicecompany.agh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Car> getAllCars(){
        return carService.getAllCars();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Car getCarById(@PathVariable("id") int id){
        return carService.getCarById(id);
    }

}
