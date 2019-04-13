package com.servicecompany.agh.employees;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Accountant extends AbstractEmployee {

    @Builder
    public Accountant(Integer id, Integer id_role, String role, String name, String surname,
                      String login, String password, Integer experience, Integer experienceInCompany) {
        super(id, id_role, role, name, surname, login, password, experience, experienceInCompany);
    }

    public Accountant() {
    }
}
