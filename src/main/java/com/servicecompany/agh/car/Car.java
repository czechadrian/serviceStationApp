package com.servicecompany.agh.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    private String client;
    private Long phoneNumber;
    private String model;
    private String brand;
    private String registrationNumber;
//    private List<String> flawsHistory;

}
