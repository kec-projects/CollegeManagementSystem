package com.collegemanagementsystem.Entity.collegeDetailsEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="CollegeDetails")
public class CollegeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="College_sr")
    private Long sr;
    @Column(name="College_id")
    private Long id;
    @Column(name="College_name")
    private String name;
    @Column(name="College_address")
    private String address;
    @Column(name="College_phone")
    private String phone;
    @Column(name="College_affiliation")
    private String affiliationTo;
    @Column(name="College_established")
    private Date established;



}
