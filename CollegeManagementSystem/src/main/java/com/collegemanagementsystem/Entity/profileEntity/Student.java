package com.collegemanagementsystem.Entity.profileEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Student")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_sr")
    private Long sr;
    @Column(name = "Student_userId")
    private Long userId;
    @Column(name = "Student_registrationNo")
    private String registrationNo;
    @Column(name = "Student_rollNo")
    private Long rollNo;
    @Column(name = "Student_name")
    private String name;
    @Column(name = "Student_department")
    private String department;
    @Column(name = "Student_batch")
    private String batch;
    @Column(name = "Student_category")
    private String category;
    @Column(name = "Student_fatherName")
    private String fatherName;
    @Column(name = "Student_motherName")
    private String motherName;
    @Column(name = "Student_fatherContactNo")
    private String fatherContactNo;
    @Column(name = "Student_aadhar")
    private String aadhaarNo;
    @Column(name = "Student_dob")
    private String dateOfBirth;
    @Column(name = "Student_blood")
    private String bloodGroup;
    @Column(name = "Student_sem")
    private String semester;

    public String getSemester_department() {
        return semester+department;
    }
    public void setSemester_department(String semester, String department) {
        this.semester=semester;
        this.department=department;
    }

   }