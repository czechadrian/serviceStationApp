package com.servicecompany.agh.service;

import com.servicecompany.agh.dao.CarDao;
import com.servicecompany.agh.car.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarService {

    @Autowired
    @Qualifier("mysqlCar")
    private CarDao carDao;

    public Collection<Car> getAllCars(){
        return this.carDao.getAllCars();
    }

    public Car getCarById(int id){
        return this.carDao.getCarById(id);
    }

}
