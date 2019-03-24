package com.servicecompany.agh.employees;

import com.servicecompany.agh.calendars.WorkCalendar;

public class Mechanic extends AbstractEmployee {

    private WorkCalendar<Mechanic> workCalendar;

    public Mechanic(String name, String surname, Integer experience, Integer experienceInCompany, WorkCalendar<Mechanic> workCalendarMechanic) {
        super(name, surname, experience, experienceInCompany);
        this.workCalendar = workCalendarMechanic;
    }

    public WorkCalendar<Mechanic> getWorkCalendar() {
        return workCalendar;
    }
}
