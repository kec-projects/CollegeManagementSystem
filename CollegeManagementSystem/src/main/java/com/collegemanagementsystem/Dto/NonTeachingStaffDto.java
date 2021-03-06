package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NonTeachingStaffDto {
    private Long sr;
    private Long userId;
    private String name;
    private String employeeId;
    private String bloodGroup;
    private Long aadhaarNo;
    private String designation;
    private String dateOfJoining;
    private String dateOfBirth;
    private String dateOfLeaving;
    private String address;
    private String pincode;
    private Long mobileNo;
    private String email;


}
