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
    public Logistician(Integer id, String role, String name, String surname, Integer experience, Integer experienceInCompany, WorkCalendar<Logistician> workCalendar) {
        super(id, role, name, surname, experience, experienceInCompany);
        this.workCalendar = workCalendar;
    }

    public Logistician(WorkCalendar<Logistician> workCalendar) {
        this.workCalendar = workCalendar;
    }

}
