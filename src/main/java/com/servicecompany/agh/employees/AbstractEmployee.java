package com.servicecompany.agh.employees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AbstractEmployee {

    private Integer id;
    private String role;
    private String name;
    private String surname;
    private Integer experience;
    private Integer experienceInCompany;
}
