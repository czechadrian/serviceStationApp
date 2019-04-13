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
@RequestMapping("/api/cars")
public class CarController {

    private final Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping
    public Collection<Car> cars() {
        return carService.getAllCars();
    }

    @GetMapping(value = "/byId/{id}")
    public Car getCarById(@PathVariable("id") int id) {
        return carService.getCarById(id);
    }

    @GetMapping(value = "/byOwnerSurname/{surname}")
    public Collection<Car> getCarByOwnerSurname(@PathVariable("surname") String surname) {
        return carService.getCarByOwnerSurname(surname);
    }

    @GetMapping(value = "/byOwnerPhoneNumber/{phoneNumber}")
    public Collection<Car> getCarByOwnerPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return carService.getCarByOwnerPhoneNumber(phoneNumber);
    }

    @GetMapping(value = "/byRegistrationNumber/{registrationNumber}")
    public Car getCarByRegistrationNumber(@PathVariable("registrationNumber") String registrationNumber) {
        return carService.getCarByRegistrationNumber(registrationNumber);
    }

    @GetMapping(value = "/byBrand/{brand}")
    public Collection<Car> getCarByBrand(@PathVariable("brand") String brand) {
        return carService.getCarByBrand(brand);
    }

    @GetMapping(value = "/byModel/{model}")
    public Collection<Car> getCarByOwnerByModel(@PathVariable("model") String model) {
        return carService.getCarByModel(model);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCarById(@PathVariable("id") int id){
        carService.deleteCarById(id);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCarById(@RequestBody Car car, @PathVariable("id") int id){
        carService.updateCarById(car,id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertCarToDb(@RequestBody Car car){
        carService.insertCarToDb(car);
    }
}