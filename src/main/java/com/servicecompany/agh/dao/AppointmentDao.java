package com.servicecompany.agh.dao;

import com.servicecompany.agh.car.Appointment;

import java.util.Collection;
import java.util.Optional;

public interface AppointmentDao {


    Collection<Appointment> getAllAppointments();

    Optional<Appointment> getAppointmentById(int id);

    Optional<Appointment> getAppointmentByNameUser(String nameUser);

    Optional<Appointment> getAppointmentByNumberCar(String numberCar);

    void deleteAppointmentById(int id);

    void updateAppointmentById(Appointment appointment);

    void insertAppointmentToDb(Appointment appointment);

}
