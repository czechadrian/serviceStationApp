package com.servicecompany.agh.employees;

import com.servicecompany.agh.calendars.WorkCalendarLogistician;

public class Logistician extends AbstractEmployee{

    private WorkCalendarLogistician workCalendarLogistician;

    public Logistician(String name, String surname, Integer experience, Integer experienceInCompany) {
        super(name, surname, experience, experienceInCompany);
        this.workCalendarLogistician = new WorkCalendarLogistician();
    }

    public WorkCalendarLogistician getWorkCalendarLogistician() {
        return workCalendarLogistician;
    }
}
