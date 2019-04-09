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

@Repository("mysqlEmployee")
public class MySqlEmployeeImpl implements EmployeeDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static class EmployeeRowMapper implements RowMapper<AbstractEmployee> {

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
        AbstractEmployee abstractEmployee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), username);
        return abstractEmployee;
    }

    @Override
    public Collection<AbstractEmployee> getAllManagers() {
        // SELECT all info about Menagers
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = 1";
        List<AbstractEmployee> abstractEmployee = jdbcTemplate.query(sql, new EmployeeRowMapper());
        return abstractEmployee;
    }

    @Override
    public Collection<AbstractEmployee> getAllLogistician() {
        // SELECT all info about Logistician
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = 2";
        List<AbstractEmployee> abstractEmployee = jdbcTemplate.query(sql, new EmployeeRowMapper());
        return abstractEmployee;
    }

    @Override
    public Collection<AbstractEmployee> getAllMechanics() {
        // SELECT all info about Mechanics
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = 3";
        List<AbstractEmployee> abstractEmployee = jdbcTemplate.query(sql, new EmployeeRowMapper());
        return abstractEmployee;
    }

    @Override
    public void insertEmployeeToDb(AbstractEmployee abstractEmployee) {
        final String sql = "INSERT INTO USER (id,role,name,surname,experience,experienceInCompany) VALUES (?,?,?,?,?,?)";
        final int id = abstractEmployee.getId();
        final String role = abstractEmployee.getRole();
        final String name = abstractEmployee.getName();
        final String surname = abstractEmployee.getSurname();
        final int experience = abstractEmployee.getExperience();
        final int experienceInCompany = abstractEmployee.getExperienceInCompany();
        jdbcTemplate.update(sql, new Object[]{id, role, name, surname, experience, experienceInCompany});

    }

    @Override
    public Collection<AbstractEmployee> getAllAccountants() {
        // SELECT all info about Accountants
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = 4";
        List<AbstractEmployee> abstractEmployee = jdbcTemplate.query(sql, new EmployeeRowMapper());
        return abstractEmployee;
    }

    @Override
    public void updateEmployeeById(AbstractEmployee abstractEmployee, int id) {
        final String sql = "UPDATE USER SET (idKeeper = ?role= ?,name = ?,surname= ?,experience = ?,experienceInCompany = ? WHERE id = ?)";
        final int idKeeper = abstractEmployee.getId();
        final String role = abstractEmployee.getRole();
        final String name = abstractEmployee.getName();
        final String surname = abstractEmployee.getSurname();
        final int experience = abstractEmployee.getExperience();
        final int experienceInCompany = abstractEmployee.getExperienceInCompany();
        jdbcTemplate.update(sql, new Object[]{idKeeper, role, name, surname, experience, experienceInCompany, id});
    }

    @Override
    public void deleteEmployeeById(int id) {
        final String sql = "DELETE FROM USER WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}
