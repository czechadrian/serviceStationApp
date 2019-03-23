package com.servicecompany.agh.calendars;

import java.util.ArrayList;

public class WorkCalendar<T> {

    private ArrayList<String> workCalendar = new ArrayList<>();

    public ArrayList<String> getWorkCalendar() {
        return workCalendar;
    }

    public void setWorkCalendar(ArrayList<String> workCalendar) {
        this.workCalendar = workCalendar;
    }
}
