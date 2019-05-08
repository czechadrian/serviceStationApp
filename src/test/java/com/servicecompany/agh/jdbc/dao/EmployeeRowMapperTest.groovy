package com.servicecompany.agh.jdbc.dao

import com.servicecompany.agh.employees.AbstractEmployee
import spock.lang.Specification
import spock.lang.Subject
import java.sql.ResultSet

import static com.servicecompany.agh.jdbc.queries.helpers.EmployeeResultSetMockValues.*
import static com.servicecompany.agh.dao.MySqlEmployeeImpl.EmployeeRowMapper


class EmployeeRowMapperTest extends Specification {

    @Subject
    EmployeeRowMapper rowMapper = new EmployeeRowMapper()

    def "Create an Employee"() {
        given: "Set values"
        def resultSet = setupResultSet()
        when: "Using mapRow method"
        def employeeEntity = (AbstractEmployee) rowMapper.mapRow(resultSet, 1)
        then: "Asserts"
        verifyResult(employeeEntity)
    }

    def setupResultSet() {
        def resultSet = Mock(ResultSet)
        resultSet.getInt("id") >> EMPLOYEE_ID
        resultSet.getString("setRole") >> EMPLOYEE_ROLE
        resultSet.getString("name") >> EMPLOYEE_NAME
        resultSet.getString("surname") >> EMPLOYEE_SURNAME
        resultSet.getInt("experience") >> EMPLOYEE_EXPERIENCE
        resultSet.getInt("experienceInCompany") >> EMPLOYEE_EXEPERIENCE_IN_COMPANY

        return resultSet
    }

    def verifyResult(employeeEntity) {

        assert employeeEntity.getId() == EMPLOYEE_ID
        assert employeeEntity.getSetRole() == EMPLOYEE_ROLE
        assert employeeEntity.getName() == EMPLOYEE_NAME
        assert employeeEntity.getSurname() == EMPLOYEE_SURNAME
        assert employeeEntity.getExperience() == EMPLOYEE_EXPERIENCE
        assert employeeEntity.getExperienceInCompany() == EMPLOYEE_EXEPERIENCE_IN_COMPANY

        return true
    }

}