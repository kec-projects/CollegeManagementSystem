package com.collegemanagementsystem.Entity.AttendanceEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ClassAttendance")
@Getter
@Setter
public class ClassAttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClassAttendance_sr")
    private Long sr;
    @Column(name = "ClassAttendance_classId")
    private Long classId;
    @Column(name = "ClassAttendance_date")
    private LocalDate date;
    @Column(name = "ClassAttendance_time")
    private LocalTime time;

}
