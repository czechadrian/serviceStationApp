package com.servicecompany.agh.dao;

import com.servicecompany.agh.employees.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

@Repository("mysqlRole")
public class MySqlRoleImpl implements RoleDao {

    private final Logger LOGGER = LoggerFactory.getLogger(MySqlRoleImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class RoleRowMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet resultSet, int i) throws SQLException {
            Role role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setRole(resultSet.getString("role"));
            return role;
        }
    }

    final String sql = "SELECT id, role FROM ROLE";

    @Override
    public Collection<Role> getAllRoles() {
        return jdbcTemplate.query(sql, new RoleRowMapper());
    }

    @Override
    public Optional<Role> getRoleById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sqlRole = sql + " WHERE ROLE.id = ?";
        Role role = jdbcTemplate.queryForObject(sqlRole, new RoleRowMapper(), id);
        return Optional.of(role);
    }
}
