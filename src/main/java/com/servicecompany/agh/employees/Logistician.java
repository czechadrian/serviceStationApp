package com.servicecompany.agh.employees;

import com.servicecompany.agh.calendars.WorkCalendar;

public class Logistician extends AbstractEmployee {

    private WorkCalendar<Logistician> workCalendar;

    public Logistician(String name, String surname, Integer experience, Integer experienceInCompany, WorkCalendar<Logistician> workCalendarLogistician) {
        super(name, surname, experience, experienceInCompany);
        this.workCalendar = workCalendarLogistician;
    }

    public WorkCalendar<Logistician> getWorkCalendar() {
        return workCalendar;
    }
}
