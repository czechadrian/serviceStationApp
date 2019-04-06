package com.servicecompany.agh.dao;

import com.servicecompany.agh.employees.AbstractEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysql")
public class MySqlEmployeeImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class EmployeeRowMapper implements RowMapper<AbstractEmployee> {

        @Override
        public AbstractEmployee mapRow(ResultSet resultSet, int i) throws SQLException {
            AbstractEmployee abstractEmployee = new AbstractEmployee();
            abstractEmployee.setId(resultSet.getInt("id"));
            abstractEmployee.setRole(resultSet.getString("role"));
            abstractEmployee.setName(resultSet.getString("name"));
            abstractEmployee.setSurname(resultSet.getString("surname"));
            abstractEmployee.setExperience(resultSet.getInt("experience"));
            abstractEmployee.setExperienceInCompany(resultSet.getInt("experienceInCompany"));
            return abstractEmployee;
        }
    }


    @Override
    public Collection<AbstractEmployee> getAllEmployees() {
        // SELECT * FROM table_name
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany FROM USER " +
                "JOIN ROLE ON USER.id_role=ROLE.id";
        List<AbstractEmployee> abstractEmployees = jdbcTemplate.query(sql, new EmployeeRowMapper());
        return abstractEmployees;
    }

    @Override
    public AbstractEmployee getEmployeeById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = ?";
        AbstractEmployee abstractEmployee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
        return abstractEmployee;

    }

    @Override
    public AbstractEmployee getEmployeeByUsername(String username) {
        final String sql = "SELECT USER.id,role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.login = ?";
        AbstractEmployee abstractEmployee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(),username);
        return abstractEmployee;
    }
}
