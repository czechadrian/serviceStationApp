package com.servicecompany.agh.jdbc.dao

import com.servicecompany.agh.calendars.WorkCalendar
import com.servicecompany.agh.dao.MySqlEmployeeImpl
import com.servicecompany.agh.employees.AbstractEmployee
import com.servicecompany.agh.employees.Mechanic
import com.servicecompany.agh.service.EmployeeService
import groovy.sql.Sql
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import spock.lang.Specification
import spock.lang.Subject


import static com.servicecompany.agh.jdbc.queries.helpers.MySqlEmployeeImplMockValues.*

import java.sql.ResultSet

import static com.servicecompany.agh.jdbc.queries.helpers.MySqlEmployeeImplMockValues.TEST_EMPLOYEES

class MySqlEmployeeImplTest extends Specification {

    private final Logger LOGGER = LoggerFactory.getLogger(MySqlEmployeeImplTest.class)

    @Autowired
    private JdbcTemplate jdbcTemplate
    private EmployeeService employeeService

    @Subject
    MySqlEmployeeImpl mySqlEmployee = new MySqlEmployeeImpl()


    def "GetAllEmployees"() {
        given:
        def smth = setupResultSet1()
        when:

        def db = [url:'jdbc:mysql://servicestationdbdev.czntefjg545i.eu-west-2.rds.amazonaws.com:3306/serviceStationDbDev?useSSL=false', user:'adminfranek', password:'korelacja', driver:'com.mysql.cj.jdbc.Driver']
        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

        sql.execute('SELECT * FROM USER?')
        LOGGER.info(sql)

        then:
        verifyResult1(getAllEmployees2)

    }



    def "GetEmployeeById"() {
        given:
        def resulSet = setupResultSet2()
        when:
        def getEmployeeById = (AbstractEmployee) employeeService.getEmployeeById(1)
        then:
        verifyResult2(getEmployeeById)
    }




    def setupResultSet1() {

        def db = [url:'jdbc:mysql://servicestationdbdev.czntefjg545i.eu-west-2.rds.amazonaws.com:3306/serviceStationDbDev?useSSL=false', user:'adminfranek', password:'korelacja', driver:'com.mysql.cj.jdbc.Driver']
        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)
        sql.execute 'SELECT * FROM USER'

        return sql
    }

    def verifyResult1(getAllEmployees) {

        assert getAllEmployees == TEST_EMPLOYEES

        return true
    }










    def setupResultSet2() {
        def db = [url:'jdbc:mysql://servicestationdbdev.czntefjg545i.eu-west-2.rds.amazonaws.com:3306/serviceStationDbDev?useSSL=false', user:'adminfranek', password:'korelacja']
        def sql = Sql.newInstance(db.url, db.user, db.password)

        def resultSet = jdbcTemplate.query(sql, new MySqlEmployeeImpl.EmployeeRowMapper())
        Mechanic mechanic1 = new Mechanic(1,"role", "name", "surname", 1, 1, new WorkCalendar<Mechanic>() )

        //def resultSet = (Mechanic) mechanic1

        return resultSet
    }

    def verifyResult2(getEmployeeById) {

        return true
    }
}
