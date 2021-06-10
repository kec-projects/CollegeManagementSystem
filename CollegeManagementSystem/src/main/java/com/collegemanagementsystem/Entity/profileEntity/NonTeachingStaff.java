package com.collegemanagementsystem.Entity.profileEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "NonTeachingStaff")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NonTeachingStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NonTeaching_sr")
    private Long sr;
    @Column(name = "NonTeaching_userId")
    private Long userId;
    @Column(name = "NonTeaching_name")
    private String name;
    @Column(name = "NonTeaching_employeeId")
    private String employeeId;
    @Column(name = "NonTeaching_blood")
    private String bloodGroup;
    @Column(name = "NonTeaching_aadhaar")
    private Long aadhaarNo;
    @Column(name = "NonTeaching_designation")
    private String designation;
    @Column(name = "NonTeaching_doj")
    private Date dateOfJoining;
    @Column(name = "NonTeaching_dob")
    private Date dateOfBirth;
    @Column(name = "NonTeaching_dol")
    private Date dateOfLeaving;


}
