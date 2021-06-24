package com.collegemanagementsystem.Entity.profileEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Faculty")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Faculty_sr")
    private Long sr;
    @Column(name = "Faculty_userId")
    @Id
    private Long userId;
    @Column(name = "Faculty_name")
    private String name;
    @Column(name = "Faculty_employId")
    private String employmentId;
    @Column(name = "Faculty_department")
    private String department;
    @Column(name = "Faculty_dob")
    private Date dateOfBirth;
    @Column(name = "Faculty_doj")
    private Date dateOfJoining;
    @Column(name = "Faculty_dol")
    private Date dateOfLeaving;
    @Column(name = "Faculty_blood")
    private String bloodGroup;
    @Column(name = "Faculty_aadhaar")
    private Long aadhaarNo;
    @Column(name="Faculty_mobileNo")
    private Long mobileNo;
    @Column(name="Faculty_Address")
    private String address;
    @Column(name="Faculty_pincode")
    private String pincode;


}