package com.servicecompany.agh.dao;

import com.servicecompany.agh.employees.AbstractEmployee;

import java.util.Collection;


public interface EmployeeDao {

    Collection<AbstractEmployee> getAllEmployees();

    Collection<AbstractEmployee> getAllMechanics();

    Collection<AbstractEmployee> getAllLogistician();

    Collection<AbstractEmployee> getAllAccountants();

    Collection<AbstractEmployee> getAllManagers();

    AbstractEmployee getEmployeeById(int id);

    AbstractEmployee getEmployeeByUsername(String username);

    void deleteEmployeeById(int id);

    void insertEmployeeToDb(AbstractEmployee abstractEmployee);

    void updateEmployeeById(AbstractEmployee abstractEmployee, int id);

}
