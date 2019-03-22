package com.servicecompany.agh;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AbstractEmployee implements Employee {

    private final String name;
    private final String surname;
    private final Integer experience;
    private final Integer experienceInCompany;
}
