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

    public void deleteCarById(int id ) { this.carDao.deleteCarById(id);}

    public void updateCarById(Car car,int id){ this.carDao.updateCarById(car,id);}

    public void insertCarToDb(Car car){this.carDao.insertCarToDb(car);}
}
