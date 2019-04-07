package com.servicecompany.agh.dao;

import com.servicecompany.agh.car.Car;

import java.util.Collection;


public interface CarDao {

    Collection<Car> getAllCars();

    Car getCarById(int id);

    void deleteCarById(int id);

    void updateCarById(Car car,int id);

    void insertCarToDb(Car car);
}
