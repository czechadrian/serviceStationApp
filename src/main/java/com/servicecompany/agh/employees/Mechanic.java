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
    public Mechanic(Integer id, String role, String name, String surname, Integer experience, Integer experienceInCompany, WorkCalendar<Mechanic> workCalendar) {
        super(id, role, name, surname, experience, experienceInCompany);
        this.workCalendar = workCalendar;
    }

    public Mechanic() {
    }
}
