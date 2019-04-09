package com.servicecompany.agh.service;

import com.servicecompany.agh.dao.EmployeeDao;
import com.servicecompany.agh.employees.AbstractEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeService {

    @Autowired
    @Qualifier("mysqlEmployee")
    private EmployeeDao employeeDao;

  public void deleteEmployeeById(int id) {
        this.employeeDao.deleteEmployeeById(id);
    }


    public Collection<AbstractEmployee> getAllEmployees() {
        return this.employeeDao.getAllEmployees();
    }

    public AbstractEmployee getEmployeeById(int id) {
        return this.employeeDao.getEmployeeById(id);
    }

    public AbstractEmployee getEmployeeByUsername(String username) {
        return this.employeeDao.getEmployeeByUsername(username);
    }

    public Collection<AbstractEmployee> getAllLogistician() {
        return this.employeeDao.getAllLogistician();
    }

    public Collection<AbstractEmployee> getAllMechanics() {
        return this.employeeDao.getAllMechanics();
    }

    public Collection<AbstractEmployee> getAllAccountants() {
        return this.employeeDao.getAllAccountants();
    }

    public Collection<AbstractEmployee> getAllManagers() {
        return this.employeeDao.getAllManagers();
    }

    public void insertEmployeeToDb(AbstractEmployee abstractEmployee) {
      this.employeeDao.insertEmployeeToDb(abstractEmployee);

    }

    public void updateEmployeeById(AbstractEmployee abstractEmployee, int id) {
        this.employeeDao.updateEmployeeById(abstractEmployee,id);
            }
/*

    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudentToDb(student);
    }
    */
}
