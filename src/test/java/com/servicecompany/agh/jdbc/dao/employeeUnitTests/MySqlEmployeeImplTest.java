package com.servicecompany.agh.jdbc.dao.employeeUnitTests;

import com.servicecompany.agh.dao.EmployeeDao;
import com.servicecompany.agh.employees.AbstractEmployee;
import org.junit.Test;
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
public class MySqlEmployeeImplTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void getAllEmployees() {
        Collection<AbstractEmployee> listOfEmployees = employeeDao.getAllEmployees();
        Assert.assertNotNull(listOfEmployees);
    }

    @Test
    public void getEmployeeById() {
        AbstractEmployee emp = new AbstractEmployee(99,1,"Manager", "Maciek","Pomaranski", "Sabreboi123","Sabrelove123", 1, 1);
        employeeDao.insertEmployeeToDb(emp);
        AbstractEmployee testEmployee = employeeDao.getEmployeeByLogin("Sabreboi123");
        Assert.assertTrue(employeeDao.getEmployeeById(testEmployee.getId()).get().getId() == testEmployee.getId());
        employeeDao.deleteEmployeeById(testEmployee.getId());
    }

    @Test
    public void getEmployeeByLogin() {
        AbstractEmployee emp = new AbstractEmployee(99,1,"Manager", "Maciek","Pomaranski", "Sabreboi123","Sabrelove123", 1, 1);
        employeeDao.insertEmployeeToDb(emp);
        AbstractEmployee testEmployee = employeeDao.getEmployeeByLogin("Sabreboi123");
        Assert.assertTrue(testEmployee.getName().equals("Maciek"));
        employeeDao.deleteEmployeeById(testEmployee.getId());
    }

    @Test
    public void getAllManagers() {
        //AbstractEmployee emp1 = new AbstractEmployee(99,1,"Manager", "Maciek","Pomaranski", "Sabreboi123","Tosia123", 1, 1);
        //AbstractEmployee emp2 = new AbstractEmployee(99,1,"Manager", "Adrian","Czech", "Matula123","Sabrelove123", 1, 1);
        //employeeDao.insertEmployeeToDb(emp1);
        //employeeDao.insertEmployeeToDb(emp2);
        Collection<AbstractEmployee> listOfManagers = employeeDao.getAllManagers();
        Iterator iterator = listOfManagers.iterator();
        while (iterator.hasNext()){
            AbstractEmployee empTest = (AbstractEmployee) iterator.next();
            Assert.assertTrue(empTest.getRole().equals("Manager"));
            //employeeDao.deleteEmployeeById(empTest.getId());
        }

    }

    @Test
    public void getAllLogisticians() {
        //AbstractEmployee emp1 = new AbstractEmployee(99,1,"Manager", "Maciek","Pomaranski", "Sabreboi123","Tosia123", 1, 1);
        //AbstractEmployee emp2 = new AbstractEmployee(99,1,"Manager", "Adrian","Czech", "Matula123","Sabrelove123", 1, 1);
        //employeeDao.insertEmployeeToDb(emp1);
        //employeeDao.insertEmployeeToDb(emp2);
        Collection<AbstractEmployee> listOfLogisticians = employeeDao.getAllLogisticians();
        Iterator iterator = listOfLogisticians.iterator();
        while (iterator.hasNext()){
            AbstractEmployee empTest = (AbstractEmployee) iterator.next();
            Assert.assertTrue(empTest.getRole().equals("Logistician"));
            //employeeDao.deleteEmployeeById(empTest.getId());
        }
    }

    @Test
    public void getAllMechanics() {
        //AbstractEmployee emp1 = new AbstractEmployee(99,1,"Manager", "Maciek","Pomaranski", "Sabreboi123","Tosia123", 1, 1);
        //AbstractEmployee emp2 = new AbstractEmployee(99,1,"Manager", "Adrian","Czech", "Matula123","Sabrelove123", 1, 1);
        //employeeDao.insertEmployeeToDb(emp1);
        //employeeDao.insertEmployeeToDb(emp2);
        Collection<AbstractEmployee> listOfMechanics = employeeDao.getAllMechanics();
        Iterator iterator = listOfMechanics.iterator();
        while (iterator.hasNext()){
            AbstractEmployee empTest = (AbstractEmployee) iterator.next();
            Assert.assertTrue(empTest.getRole().equals("Mechanic"));
            //employeeDao.deleteEmployeeById(empTest.getId());
        }
    }

    @Test
    public void getAllAccountants() {
        //AbstractEmployee emp1 = new AbstractEmployee(99,1,"Manager", "Maciek","Pomaranski", "Sabreboi123","Tosia123", 1, 1);
        //AbstractEmployee emp2 = new AbstractEmployee(99,1,"Manager", "Adrian","Czech", "Matula123","Sabrelove123", 1, 1);
        //employeeDao.insertEmployeeToDb(emp1);
        //employeeDao.insertEmployeeToDb(emp2);
        Collection<AbstractEmployee> listOfAccountants = employeeDao.getAllAccountants();
        Iterator iterator = listOfAccountants.iterator();
        while (iterator.hasNext()){
            AbstractEmployee empTest = (AbstractEmployee) iterator.next();
            Assert.assertTrue(empTest.getRole().equals("Accountant"));
            //employeeDao.deleteEmployeeById(empTest.getId());
        }
    }

    @Test
    public void insertEmployeeToDb() {
        AbstractEmployee emp = new AbstractEmployee(99,1,"Manager", "Maciek","Pomaranski", "Sabreboi123","Sabrelove123", 1, 1);
        employeeDao.insertEmployeeToDb(emp);
        AbstractEmployee insertTest = employeeDao.getEmployeeByLogin("Sabreboi123");
        Assert.assertNotNull(insertTest);
        employeeDao.deleteEmployeeById(insertTest.getId());
    }

    @Test
    public void updateEmployeeById() {
        AbstractEmployee emp = new AbstractEmployee(99,1,"Manager", "Maciek","Pomaranski", "Sabreboi123","Sabrelove123", 1, 1);
        employeeDao.insertEmployeeToDb(emp);
        AbstractEmployee insertTest = employeeDao.getEmployeeByLogin("Sabreboi123");
        AbstractEmployee newEmp = new AbstractEmployee(insertTest.getId(),1,"Manager", "Adrian","Czech", "Matula123","Sabrelove123", 1, 1);
        employeeDao.updateEmployeeById(newEmp);
        employeeDao.deleteEmployeeById(insertTest.getId());
    }
}