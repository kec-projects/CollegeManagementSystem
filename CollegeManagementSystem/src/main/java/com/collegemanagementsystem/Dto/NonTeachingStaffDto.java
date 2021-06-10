package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    private Date dateOfJoining;
    private Date dateOfBirth;
    private Date dateOfLeaving;

}
