package com.servicecompany.agh.jdbc.dao.carUnitTests;

import org.junit.Test;
import com.servicecompany.agh.car.Car;
import com.servicecompany.agh.dao.CarDao;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MySqlCarImplTest {

    @Autowired
    CarDao carDao;

    @Test
    public void getAllCars() {
        Collection<Car> listOfCars = carDao.getAllCars();
        System.out.println(listOfCars.toString());
        Assert.assertNotNull(listOfCars);
    }

    @Test
    public void getCarById() {
        Car car = new Car(99,"Maciek", 808808808L, "Lanos", "Daewoo", "RJSF520");
        carDao.insertCarToDb(car);
        Car testCar = carDao.getCarByRegistrationNumber("RJSF520");
        int id = testCar.getId();
        Assert.assertTrue(carDao.getCarById(id).get().getId() == id);
        carDao.deleteCarById(id);
    }

    @Test
    public void getCarByOwnerSurname() {
        Car car1 = new Car(99,"Maciek", 808808808L, "Lanos", "Daewoo", "RJSF522");
        Car car2 = new Car(99,"Maciek", 808808809L, "Matiz", "Daewoo", "RJSF523");
        carDao.insertCarToDb(car1);
        carDao.insertCarToDb(car2);
        Collection<Car> listOfCarsBySurnames = carDao.getCarByOwnerSurname("Maciek");
        Iterator iterator = listOfCarsBySurnames.iterator();
        while(iterator.hasNext()) {
            Car carTest = (Car)iterator.next();
            Assert.assertTrue(carTest.getClient().equals("Maciek"));
            carDao.deleteCarById(carTest.getId());
        }
    }

    @Test
    public void getCarByOwnerPhoneNumber() {
        Car car1 = new Car(99,"Maciek", 808808808L, "Lanos", "Daewoo", "RJSF522");
        Car car2 = new Car(99,"Maciek", 808808808L, "Matiz", "Daewoo", "RJSF523");
        carDao.insertCarToDb(car1);
        carDao.insertCarToDb(car2);
        Collection<Car> listOfCarsByPhoneNumbers = carDao.getCarByOwnerPhoneNumber("808808808");
        Iterator iterator = listOfCarsByPhoneNumbers.iterator();
        while(iterator.hasNext()) {
            Car carTest = (Car)iterator.next();
            Assert.assertTrue(carTest.getPhoneNumber() == 808808808L);
            carDao.deleteCarById(carTest.getId());
        }
    }

    @Test
    public void getCarByRegistrationNumber() {
        Car car = new Car(99,"Maciek", 808808808L, "Lanos", "Daewoo", "RJSF522");
        carDao.insertCarToDb(car);
        Car testCar = carDao.getCarByRegistrationNumber("RJSF522");
        Assert.assertTrue(testCar.getModel().equals("Lanos"));
        carDao.deleteCarById(testCar.getId());
    }

    @Test
    public void getCarByBrand() {
        Car car1 = new Car(99,"Maciek", 808808808L, "Lanos", "Daewoo", "RJSF522");
        Car car2 = new Car(99,"Maciek", 808808809L, "Matiz", "Daewoo", "RJSF523");
        carDao.insertCarToDb(car1);
        carDao.insertCarToDb(car2);
        Collection<Car> listOfCarsBySurnames = carDao.getCarByBrand("Daewoo");
        Iterator iterator = listOfCarsBySurnames.iterator();
        while(iterator.hasNext()) {
            Car carTest = (Car)iterator.next();
            Assert.assertTrue(carTest.getBrand().equals("Daewoo"));
            carDao.deleteCarById(carTest.getId());
        }
    }

    @Test
    public void getCarByModel() {
        Car car1 = new Car(99,"Maciek", 808808808L, "Lanos", "Daewoo", "RJSF522");
        Car car2 = new Car(99,"Maciek", 808808809L, "Lanos", "Daewoo", "RJSF523");
        carDao.insertCarToDb(car1);
        carDao.insertCarToDb(car2);
        Collection<Car> listOfCarsBySurnames = carDao.getCarByModel("Lanos");
        Iterator iterator = listOfCarsBySurnames.iterator();
        while(iterator.hasNext()) {
            Car carTest = (Car)iterator.next();
            Assert.assertTrue(carTest.getModel().equals("Lanos"));
            carDao.deleteCarById(carTest.getId());
        }
    }

    @Test
    public void deleteCarById() {
        Car car = new Car(99,"Maciek", 808808808L, "Lanos", "Daewoo", "RJSF522");
        carDao.insertCarToDb(car);
        Collection<Car> listOfCars = carDao.getCarByModel("Lanos");
        Assert.assertFalse(listOfCars.isEmpty());
        int id = listOfCars.iterator().next().getId();
        carDao.deleteCarById(id);
        listOfCars = carDao.getCarByModel("Lanos");
        Assert.assertTrue(listOfCars.isEmpty());

    }

    @Test
    public void updateCarById() {
        Car car = new Car(99,"Maciek", 808808808L, "Lanos", "Daewoo", "RJSF522");
        carDao.insertCarToDb(car);
        Car testCar = carDao.getCarByRegistrationNumber("RJSF522");
        Car newCar = new Car(testCar.getId(),"Maciek", 808808808L, "Nubira", "Daewoo", "RJSF522");
        carDao.updateCarById(newCar);
        Assert.assertTrue(carDao.getCarById(testCar.getId()).get().getModel().equals("Nubira"));
        carDao.deleteCarById(testCar.getId());
    }

    @Test
    public void insertCarToDb() {
        Car car = new Car(99,"Maciek", 808808808L, "Lanos", "Daewoo", "RJSF522");
        carDao.insertCarToDb(car);
        Collection<Car> listOfCars = carDao.getCarByModel("Lanos");
        Assert.assertFalse(listOfCars.isEmpty());
        int id = listOfCars.iterator().next().getId();
        carDao.deleteCarById(id);
    }
}
