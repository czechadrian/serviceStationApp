package com.servicecompany.agh.employees;

import com.servicecompany.agh.calendars.WorkCalendar;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Logistician extends AbstractEmployee {

    private WorkCalendar<Logistician> workCalendar;

    @Builder
    public Logistician(Integer id, Integer id_role, String role, String name, String surname,
                       String login, String password, Integer experience, Integer experienceInCompany,
                       WorkCalendar<Logistician> workCalendar) {
        super(id, id_role, role, name, surname, login, password, experience, experienceInCompany);
        this.workCalendar = workCalendar;
    }

    public Logistician(WorkCalendar<Logistician> workCalendar) {
        this.workCalendar = workCalendar;
    }

}
