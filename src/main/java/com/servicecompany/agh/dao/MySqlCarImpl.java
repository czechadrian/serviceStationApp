package com.servicecompany.agh.dao;

import com.servicecompany.agh.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysqlCar")
public class MySqlCarImpl implements CarDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class CarRowMapper implements RowMapper<Car> {

        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            Car car = new Car();
            car.setId(resultSet.getInt("id"));
            car.setOwner(resultSet.getString("surname"));
            car.setBrand(resultSet.getString("brand"));
            car.setModel(resultSet.getString("model"));
            car.setRegistrationNumber(resultSet.getString("registration_number"));
            return car;
        }
    }


    @Override
    public Collection<Car> getAllCars() {
        // SELECT * FROM table_name
        final String sql = "SELECT CAR.id, surname, brand, model, registration_number FROM CAR " +
                "JOIN OWNER ON CAR.id_owner=OWNER.id";
        List<Car> cars = jdbcTemplate.query(sql, new CarRowMapper());
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT CAR.id, surname, brand, model, registration_number FROM CAR " +
                "JOIN OWNER ON CAR.id_owner=OWNER.id " +
                "WHERE CAR.id = ?";
        Car car = jdbcTemplate.queryForObject(sql, new CarRowMapper(), id);
        return car;

    }



}
