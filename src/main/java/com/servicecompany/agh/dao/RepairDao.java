package com.servicecompany.agh.dao;

import com.servicecompany.agh.car.Repair;

import java.util.Collection;
import java.util.Optional;

public interface RepairDao {


    Collection<Repair> getAllRepairs();

    Optional<Repair> getRepairById(int id);

    Optional<Repair> getRepairByNameUser(String nameUser);

    Optional<Repair> getRepairByNumberCar(String numberCar);

    void deleteRepairById(int id);

    void updateRepairById(Repair repair);

    void insertRepairToDb(Repair repair);

}
