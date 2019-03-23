package com.servicecompany.agh.calendars;

public abstract class AbstarctWorkCalendar implements WorkCalendar{

    private WorkCalendar workCalendar;

    @Override
    public WorkCalendar getWorkCalendar(){
        return workCalendar;
    }
}
