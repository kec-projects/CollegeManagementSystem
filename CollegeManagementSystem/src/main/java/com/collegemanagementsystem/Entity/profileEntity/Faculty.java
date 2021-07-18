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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Faculty_sr")
    private Long sr;
    @Column(name = "Faculty_userId")
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


}