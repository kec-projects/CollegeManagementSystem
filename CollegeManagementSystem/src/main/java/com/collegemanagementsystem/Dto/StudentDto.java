package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long userId;
    private String registrationNo;
    private Long rollNo;
    private String name;
    private String department;
    private Long batch;
    private String category;
    private String fatherName;
    private String motherName;
    private String fatherContactNo;
    private String emergencyContactNo;
    private String aadhaarNo;
    private String dateOfBirth;
    private String bloodGroup;
    private String semester;

    public String getSemester_department() {
        return semester+department;
    }
    public void setSemester_department(String semester, String department) {
        this.semester=semester;
        this.department=department;
    }


}
