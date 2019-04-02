package com.servicecompany.agh.employees;

public class AbstractEmployee implements Employee{

    private Integer id;
    private String role;
    private String name;
    private String surname;
    private Integer experience;
    private Integer experienceInCompany;

    public AbstractEmployee(String name, String surname, Integer experience, Integer experienceInCompany) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.experienceInCompany = experienceInCompany;
    }

    public AbstractEmployee(){}

    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }

    @Override
    public String getRole() {
        return role;
    }
    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public Integer getExperience() {
        return experience;
    }
    @Override
    public void setExperience( int experience) { this.experience = experience; }

    @Override
    public Integer getExperienceInCompany() {
        return experienceInCompany;
    }
    @Override
    public void setExperienceInCompany( int experienceInCompany) { this.experienceInCompany = experienceInCompany; }

}
