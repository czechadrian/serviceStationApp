package com.servicecompany.agh.dao;

import com.servicecompany.agh.owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysqlOwner")
public class MySqlOwnerImpl implements OwnerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class OwnerRowMapper implements RowMapper<Owner> {

        @Override
        public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
            Owner owner = new Owner();
            owner.setId(resultSet.getInt("id"));
            owner.setName(resultSet.getString("name"));
            owner.setSurname(resultSet.getString("surname"));
            owner.setPhoneNumber(resultSet.getString("phone_number"));
            return owner;
        }
    }


    @Override
    public Collection<Owner> getAllOwners() {
        // SELECT * FROM table_name
        final String sql = "SELECT id, name, surname, phone_number FROM OWNER ";
        List<Owner> owners = jdbcTemplate.query(sql, new OwnerRowMapper());
        return owners;
    }

    @Override
    public Owner getOwnerById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT id, name, surname, phone_number FROM OWNER " +
                "WHERE id = ?";
        Owner owner = jdbcTemplate.queryForObject(sql, new OwnerRowMapper(), id);
        return owner;

    }


}
