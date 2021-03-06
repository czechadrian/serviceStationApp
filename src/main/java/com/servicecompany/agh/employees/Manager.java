package com.servicecompany.agh.employees;

import com.servicecompany.agh.calendars.WorkCalendar;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Manager extends AbstractEmployee {

    private WorkCalendar<Manager> workCalendar;

    public Manager() {
    }

    @Builder
    public Manager(Integer id, Integer idRole, String role, String name, String surname,
                       String login, String password, Integer experience, Integer experienceInCompany,
                       WorkCalendar<Manager> workCalendar) {
        super(id, idRole, role, name, surname, login, password, experience, experienceInCompany);
        this.workCalendar = workCalendar;
    }


}
