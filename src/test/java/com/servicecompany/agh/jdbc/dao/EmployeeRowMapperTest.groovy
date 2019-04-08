package com.servicecompany.agh.jdbc.dao

import com.servicecompany.agh.employees.Mechanic

import static com.servicecompany.agh.jdbc.queries.helpers.EmployeeResultSetMockValues.* //TODO save this import

import com.servicecompany.agh.employees.AbstractEmployee
import spock.lang.Specification
import spock.lang.Subject

import java.sql.ResultSet

import static com.servicecompany.agh.dao.MySqlEmployeeImpl.EmployeeRowMapper

//TODO save this import

class EmployeeRowMapperTest extends Specification {

    @Subject
    EmployeeRowMapper rowMapper = new EmployeeRowMapper()

//TODO (2) write asserts in verifyResult function , complete setup and write proper instruction in given/when/then.
    //TODO (3) after that you can prepare tests for methods in MySqlEmployeeImpl
    def "Should create Employee"() {
        given: "given"
        def resultSet = setupResultSet()
        when: "when"
        def employeeEntity = (AbstractEmployee) rowMapper.mapRow(resultSet, 1)
        then: "then"
        verifyResult(employeeEntity)
    }

    def setupResultSet() {
        def resultSet = Mock(ResultSet)
        resultSet.getInt("id") >> EMPLOYEE_ID
        resultSet.getString("role") >> EMPLOYEE_ROLE
        resultSet.getString("name") >> EMPLOYEE_NAME
        resultSet.getString("surname") >> EMPLOYEE_SURNAME
        resultSet.getInt("experience") >> EMPLOYEE_EXPERIENCE
        resultSet.getInt("experienceInCompany") >> EMPLOYEE_EXEPERIENCE_IN_COMPANY


        return resultSet
    }

    def verifyResult(employeeEntity) {

        assert employeeEntity.getId() == EMPLOYEE_ID
        assert employeeEntity.getRole() == EMPLOYEE_ROLE
        assert employeeEntity.getName() == EMPLOYEE_NAME
        assert employeeEntity.getSurname() == EMPLOYEE_SURNAME
        assert employeeEntity.getExperience() == EMPLOYEE_EXPERIENCE
        assert employeeEntity.getExperienceInCompany() == EMPLOYEE_EXEPERIENCE_IN_COMPANY

        return true
    }

}