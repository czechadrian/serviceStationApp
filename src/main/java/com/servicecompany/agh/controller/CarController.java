package com.servicecompany.agh.controller;


import com.servicecompany.agh.car.Car;
import com.servicecompany.agh.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "/{id}")
    public void deleteCarById(@PathVariable("id") int id){
        carService.deleteCarById(id);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Car car,int id){
        carService.updateCarById(car,id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertCar(@RequestBody Car car){
        carService.insertCarToDb(car);
    }
}