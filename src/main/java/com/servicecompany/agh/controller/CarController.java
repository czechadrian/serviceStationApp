package com.servicecompany.agh.controller;


import com.servicecompany.agh.car.Car;
import com.servicecompany.agh.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class CarController {

    private final Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public Collection<Car> cars() {
        return carService.getAllCars();
    }

    @GetMapping(value = "/cars/{id}")
    public Car getCarById(@PathVariable("id") int id) {
        return carService.getCarById(id);
    }
}