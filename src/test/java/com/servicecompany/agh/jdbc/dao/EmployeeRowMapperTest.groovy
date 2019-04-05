package com.servicecompany.agh.jdbc.dao

import com.servicecompany.agh.employees.AbstractEmployee
import spock.lang.Specification
import spock.lang.Subject

import java.sql.ResultSet

import static com.servicecompany.agh.dao.MySqlEmployeeImpl.EmployeeRowMapper
import static com.servicecompany.agh.jdbc.queries.helpers.EmployeeResultSetMockValues.* //TODO save this import

class EmployeeRowMapperTest extends Specification {

    @Subject
    EmployeeRowMapper rowMapper = new EmployeeRowMapper()
//TODO (2) write asserts in verifyResult function , complete setup and write proper instruction in given/when/then.
    //TODO (3) after that you can prepare tests for methods in MySqlEmployeeImpl
    def "Should create Employee"() {
        given: ""
        def resultSet = setupResultSet()
        when: ""
        def employeeEntity = (AbstractEmployee) rowMapper.mapRow(resultSet, 1)
        then: ""
        verifyResult(employeeEntity)
    }

    def setupResultSet() {
        def resultSet = Mock(ResultSet)


        return resultSet
    }

    def verifyResult(employeeEntity) {

        return true
    }

}