package com.servicecompany.agh.dao;

import com.servicecompany.agh.employees.AbstractEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

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

        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Optional<AbstractEmployee> getEmployeeById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id));

    }

    @Override
    public AbstractEmployee getEmployeeByLogin(String login) {
        final String sql = "SELECT USER.id,role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.login = ?";

        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), login);
    }

    @Override
    public Collection<AbstractEmployee> getAllManagers() {
        // SELECT all info about Menagers
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = 1";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Collection<AbstractEmployee> getAllLogisticians() {
        // SELECT all info about Logistician
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = 2";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Collection<AbstractEmployee> getAllMechanics() {
        // SELECT all info about Mechanics
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = 3";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Collection<AbstractEmployee> getAllAccountants() {
        // SELECT all info about Accountants
        final String sql = "SELECT USER.id, role, name, surname, experience, experienceInCompany " +
                "FROM USER JOIN ROLE ON USER.id_role=ROLE.id " +
                "WHERE USER.id = 4";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public void insertEmployeeToDb(AbstractEmployee abstractEmployee) {
        final String sql = "INSERT INTO USER " +
                "( id_role, name, surname, login, password, experience,experienceInCompany) " +
                "VALUES (?,?,?,?,?,?,?)";

        final int id_role = abstractEmployee.getId_role();
        final String name = abstractEmployee.getName();
        final String surname = abstractEmployee.getSurname();
        final String login = abstractEmployee.getLogin();
        final String password = abstractEmployee.getPassword();
        final int experience = abstractEmployee.getExperience();
        final int experienceInCompany = abstractEmployee.getExperienceInCompany();
        jdbcTemplate.update(sql, new Object[]{id_role, name, surname, login, password, experience, experienceInCompany});

    }

    @Override
    public void updateEmployeeById(AbstractEmployee abstractEmployee) {
        final String sql = "UPDATE USER SET id_role= ?, name = ?,surname= ?, " +
                "login = ?, password = ?, experience = ?, experienceInCompany = ? WHERE id = ?";
        final int id_role = abstractEmployee.getId_role();
        final String name = abstractEmployee.getName();
        final String surname = abstractEmployee.getSurname();
        final String login = abstractEmployee.getLogin();
        final String password = abstractEmployee.getPassword();
        final int experience = abstractEmployee.getExperience();
        final int experienceInCompany = abstractEmployee.getExperienceInCompany();
        final int id = abstractEmployee.getId();
        jdbcTemplate.update(sql, new Object[]{id_role, name, surname,
                login, password, experience, experienceInCompany, id});
    }

    @Override
    public void deleteEmployeeById(int id) {
        final String sql = "DELETE FROM USER WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}