package com.servicecompany.agh.employees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AbstractEmployee {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer idRole;
    private String role;
    private String name;
    private String surname;
    private String login;
    private String password;
    private Integer experience;
    private Integer experienceInCompany;
}

