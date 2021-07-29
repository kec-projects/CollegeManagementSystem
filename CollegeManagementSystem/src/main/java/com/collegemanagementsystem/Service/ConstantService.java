package com.collegemanagementsystem.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ConstantService {
    public LocalDate getLocalDate(){
        return LocalDate.now();
    }
    public LocalTime getLocalTime(){
        return LocalTime.now();
    }
}
