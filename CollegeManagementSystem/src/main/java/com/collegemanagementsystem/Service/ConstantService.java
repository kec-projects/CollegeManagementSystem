package com.collegemanagementsystem.Service;

import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Date;

@Service
public class ConstantService {
    public Time getLocalTime(){
        Long millis = System.currentTimeMillis();
        java.sql.Time time = new java.sql.Time(millis);
        return time;
    }
    public Date getLocalDate(){
        Long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }
}
