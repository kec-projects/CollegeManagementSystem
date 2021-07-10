package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OnlineApplicationDto {

    private Long applicationId;
    private Long userId;
    private Long registrationNo;
    private String name;
    private String department;
    private Long batch;
    private String category;
    private String fatherName;
    private String motherName;
    private String dateOfBirth;
    private String purpose;
    private Date appliedDate;
    private Date approvedDate;
    private String certificateType;
    private String status;
    private byte[] file;

}
