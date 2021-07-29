package com.collegemanagementsystem.Entity.AttendanceEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Attendance")
@Getter
@Setter
public class StudentAttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentAttendance_sr")
    private Long sr;
    @Column(name = "StudentAttendance_userId")
    private Long userId;
    @Column(name = "StudentAttendance_classId")
    private Long classId;
    @Column(name = "StudentAttendance_date")
    private LocalDate date;
    @Column(name = "StudentAttendance_time")
    private LocalTime time;
    @Column(name = "StudentAttendence_status")
    private String status;

}
