package com.servicecompany.agh.employees;

import com.servicecompany.agh.calendars.WorkCalendarMechanic;

public class Mechanic extends AbstractEmployee{

    private WorkCalendarMechanic workCalendarMechanic;

    public Mechanic(String name, String surname, Integer experience, Integer experienceInCompany, WorkCalendarMechanic workCalendarMechanic) {
        super(name, surname, experience, experienceInCompany);
        this.workCalendarMechanic = new WorkCalendarMechanic();
    }

    public WorkCalendarMechanic getWorkCalendarMechanic() {
        return workCalendarMechanic;
    }
}
