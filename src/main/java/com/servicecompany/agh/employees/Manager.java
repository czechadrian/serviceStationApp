package com.servicecompany.agh.employees;

import com.servicecompany.agh.calendars.WorkCalendarManager;

public class Manager extends AbstractEmployee {

    private WorkCalendarManager workCalendarManager;

    public Manager(String name, String surname, Integer experience, Integer experienceInCompany) {
        super(name, surname, experience, experienceInCompany);
        this.workCalendarManager = new WorkCalendarManager();
    }

    public WorkCalendarManager getWorkCalendarManager() {
        return workCalendarManager;
    }
}
