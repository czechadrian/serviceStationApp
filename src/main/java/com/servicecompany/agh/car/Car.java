package com.servicecompany.agh.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Integer id;
    private Integer id_owner;
    private String phoneNumber;
    private String model;
    private String brand;
    private String owner;
    private String registrationNumber;
    private List<String> flawsHistory;

}
