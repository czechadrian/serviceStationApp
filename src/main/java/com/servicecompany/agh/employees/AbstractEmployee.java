package com.servicecompany.agh.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AbstractEmployee {

    private Integer id;
    private String role;
    private String name;
    private String surname;
    private Integer experience;
    private Integer experienceInCompany;
}
