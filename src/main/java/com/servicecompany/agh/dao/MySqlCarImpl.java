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
            car.setPhoneNumber(resultSet.getString("phone_number"));
            car.setBrand(resultSet.getString("brand"));
            car.setModel(resultSet.getString("model"));
            car.setRegistrationNumber(resultSet.getString("registration_number"));
            return car;
        }
    }

    final String getCar = "SELECT CAR.id, surname, phone_number, brand, model, registration_number FROM CAR " +
            "JOIN OWNER ON CAR.id_owner=OWNER.id";

    @Override
    public Collection<Car> getAllCars() {
        // SELECT * FROM table_name
        final String sql = getCar;
        List<Car> cars = jdbcTemplate.query(sql, new CarRowMapper());
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = getCar + " WHERE CAR.id = ?";
        Car car = jdbcTemplate.queryForObject(sql, new CarRowMapper(), id);
        return car;
    }

    @Override
    public Collection<Car> getCarByOwnerSurname(String surname) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = getCar + " WHERE OWNER.surname = ?";
        List<Car> cars = jdbcTemplate.query(sql, new CarRowMapper(), surname);
        return cars;
    }

    @Override
    public Collection<Car> getCarByOwnerPhoneNumber(String phoneNumber) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = getCar + " WHERE OWNER.phone_number = ?";
        List<Car> cars = jdbcTemplate.query(sql, new CarRowMapper(), phoneNumber);
        return cars;
    }

    @Override
    public Car getCarByRegistrationNumber(String registrationNumber) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = getCar + " WHERE CAR.registration_number = ?";
        Car car = jdbcTemplate.queryForObject(sql, new CarRowMapper(), registrationNumber);
        return car;
    }

    public Collection<Car> getCarByBrand(String brand) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = getCar + " WHERE brand = ?";
        List<Car> cars = jdbcTemplate.query(sql, new CarRowMapper(), brand);
        return cars;
    }

    public Collection<Car> getCarByModel(String model) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = getCar + " WHERE model = ?";
        List<Car> cars = jdbcTemplate.query(sql, new CarRowMapper(), model);
        return cars;
    }

    @Override
    public void deleteCarById(int id) {
        final String sql = "DELETE FROM CAR WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }


    @Override
    public void updateCarById(Car car,int id) {
        final String sql = "UPDATE CAR SET id_owner = ?,model=?,brand=?,registration_number=? WHERE id = ?";
        final int id_owner = car.getId_owner();
        final String model = car.getModel();
        final String brand = car.getBrand();
        final String registration_number = car.getRegistrationNumber();
        jdbcTemplate.update(sql,new Object[] {id_owner,model,brand,registration_number,id});
    }

    @Override
    public void insertCarToDb(Car car) {
        final String sql = "INSERT INTO CAR (id_owner,model,brand,registration_number) VALUES (?,?,?,?)";
        final int id_owner = car.getId_owner();
        final String model = car.getModel();
        final String brand = car.getBrand();
        final String registration_number = car.getRegistrationNumber();
        jdbcTemplate.update(sql,new Object[] {id_owner,model,brand,registration_number});
    }
}
