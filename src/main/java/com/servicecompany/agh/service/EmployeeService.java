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

    public Collection<AbstractEmployee> getAllEmployees(){
        return this.employeeDao.getAllEmployees();
    }

    public AbstractEmployee getEmployeeById(int id){
        return this.employeeDao.getEmployeeById(id);
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
