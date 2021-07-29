package com.collegemanagementsystem.Entity.collegeDetailsEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="CollegeDetails")
public class CollegeDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="College_sr")
    private Long sr;
    @Id
    @Column(name="College_id")
    private Long id;
    @Column(name="College_name")
    private String name;
    @Column(name="College_address")
    private String address;
    @Column(name="College_pincode")
    private String pincode;
    @Column(name="College_phone")
    private Long phone;
    @Column(name="College_affiliation")
    private String affiliationTo;
    @Column(name="College_established")
    private LocalDate established;



}
