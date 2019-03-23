package com.servicecompany.agh.employees;

public class AbstractEmployee implements Employee {

    private final String name;
    private final String surname;
    private final Integer experience;
    private final Integer experienceInCompany;

    public AbstractEmployee(String name, String surname, Integer experience, Integer experienceInCompany) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.experienceInCompany = experienceInCompany;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public Integer getExperience() {
        return experience;
    }

    @Override
    public Integer getExperienceInCompany() {
        return experienceInCompany;
    }
}
