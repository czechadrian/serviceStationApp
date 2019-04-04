package com.servicecompany.agh.employees;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Accountant extends AbstractEmployee {

    @Builder
    public Accountant(Integer id, String role, String name, String surname, Integer experience, Integer experienceInCompany) {
        super(id, role, name, surname, experience, experienceInCompany);
    }

    public Accountant() {
    }
}
