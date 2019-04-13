package com.servicecompany.agh.employees;

import com.servicecompany.agh.calendars.WorkCalendar;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mechanic extends AbstractEmployee {

    private WorkCalendar<Mechanic> workCalendar;

    @Builder
    public Mechanic(Integer id, Integer id_role, String role, String name, String surname,
                       String login, String password, Integer experience, Integer experienceInCompany,
                       WorkCalendar<Mechanic> workCalendar) {
        super(id, id_role, role, name, surname, login, password, experience, experienceInCompany);
        this.workCalendar = workCalendar;
    }

    public Mechanic() {
    }
}
