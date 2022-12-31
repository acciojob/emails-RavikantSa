package com.driver;

import java.time.LocalTime;

public class Meeting {
    public LocalTime startTime;
    public LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public LocalTime getEndTime(){
        return this.endTime;
    }
    public LocalTime getStartTime(){
        return this.startTime;
    }
}
