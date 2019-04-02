package com.servicecompany.agh.dao;

import com.servicecompany.agh.employees.AbstractEmployee;

import java.util.Collection;


public interface EmployeeDao {

    Collection<AbstractEmployee> getAllEmployees();

    AbstractEmployee getEmployeeById(int id);

    /*
    void removeEmployeeById(int id);

    void updateEmployee(Employee student);

    void insertEmployeeToDb(Employee student);
    */
}
