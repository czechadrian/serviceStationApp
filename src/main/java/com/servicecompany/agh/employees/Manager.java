package com.servicecompany.agh.employees;

import com.servicecompany.agh.calendars.WorkCalendar;

public class Manager extends AbstractEmployee {

    private WorkCalendar<Manager> workCalendar;

    public Manager(String name, String surname, Integer experience, Integer experienceInCompany, WorkCalendar<Manager> workCalendarManager) {
        super(name, surname, experience, experienceInCompany);
        this.workCalendar = workCalendarManager;
    }

    public WorkCalendar<Manager> getWorkCalendar() {
        return workCalendar;
    }
}
