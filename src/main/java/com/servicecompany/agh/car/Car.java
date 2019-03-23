package com.servicecompany.agh.car;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private String brand;
    private String owner;
    private String registrationNumber;
    private List<String> flawsHistory;

    public Car(String model, String brand, String owner, String registrationNumber) {
        this.model = model;
        this.brand = brand;
        this.owner = owner;
        this.registrationNumber = registrationNumber;
        this. flawsHistory = new ArrayList<>();
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getOwner() {
        return owner;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public List<String> getFlawsHistory() {
        return flawsHistory;
    }
}
