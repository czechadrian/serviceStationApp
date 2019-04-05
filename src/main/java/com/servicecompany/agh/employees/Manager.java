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
    public Manager(Integer id, String role, String name, String surname, Integer experience, Integer experienceInCompany, WorkCalendar<Manager> workCalendar) {
        super(id, role, name, surname, experience, experienceInCompany);
        this.workCalendar = workCalendar;
    }


}
