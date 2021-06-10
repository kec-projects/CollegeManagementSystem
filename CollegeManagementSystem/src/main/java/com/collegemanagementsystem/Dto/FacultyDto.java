package com.collegemanagementsystem.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDto {
    private Long sr;
    private Long userId;
    private String name;
    private String employmentId;
    private String department;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private Date dateOfLeaving;
    private String bloodGroup;
    private Long aadhaarNo;



}
