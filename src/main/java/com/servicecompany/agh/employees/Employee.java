package com.servicecompany.agh.employees;


public interface Employee {

    int getId();
    void setId(int id);

    String getRole();
    void setRole(String role);

    String getName();
    void setName(String name);

    String getSurname();
    void setSurname(String surname);

    Integer getExperience();
    void setExperience(int experience);

    Integer getExperienceInCompany();
    void setExperienceInCompany(int experienceInCompany);

}
