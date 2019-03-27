package com.servicecompany.agh.dao;

import com.servicecompany.agh.employees.AbstractEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("mysql")
public class MySqlEmployeeImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class EmployeeRowMapper implements RowMapper<AbstractEmployee> {

        @Override
        public AbstractEmployee mapRow(ResultSet resultSet, int i) throws SQLException {
            AbstractEmployee abstractEmployee = new AbstractEmployee();
            abstractEmployee.setId(resultSet.getInt("id"));
            abstractEmployee.setName(resultSet.getString("name"));
            abstractEmployee.setSurname(resultSet.getString("surname"));
            abstractEmployee.setExperience(resultSet.getInt("experience"));
            abstractEmployee.setExperienceInCompany(resultSet.getInt("experienceInCompany"));
            return abstractEmployee;
        }
    }


    @Override
    public AbstractEmployee getEmployeeById(int id ){
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT id, name, surname, experience, experienceInCompany FROM USER where id = ?";
        AbstractEmployee abstractEmployee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
        return abstractEmployee;

    }



}