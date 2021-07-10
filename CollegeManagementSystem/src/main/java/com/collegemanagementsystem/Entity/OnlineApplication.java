package com.collegemanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Application")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OnlineApplication {

    @Id
    @GeneratedValue
    @Column(name = "ApplicationId")
    private Long applicationId;
    @Column(name = "UserId")
    private Long userId;
    @Column(name = "RegistrationNo")
    private Long registrationNo;
    @Column(name = "Name")
    private String name;
    @Column(name = "Department")
    private String department;
    @Column(name = "Batch")
    private Long batch;
    @Column(name = "Category")
    private String category;
    @Column(name = "FatherName")
    private String fatherName;
    @Column(name = "MotherName")
    private String motherName;
    @Column(name = "DateOfBirth")
    private String dateOfBirth;
    @Column(name = "Purpose")
    private String purpose;
    @Column(name = "CertificateTaken")
    private String certificateType;
    @Column(name = "AppliedDate")
    private Date appliedDate;
    @Column(name = "approvedDate")
    private Date approvedDate;
    @Column(name = "Status")
    private String status;
    @Lob
    @Column(name = "uploadedfile")
    private byte[] file;



}
