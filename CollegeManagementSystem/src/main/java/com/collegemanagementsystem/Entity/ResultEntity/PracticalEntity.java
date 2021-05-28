package com.collegemanagementsystem.Entity.ResultEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "resultPractical")
public class PracticalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="practical_sr")
    private Long sr;
    @Column(name="practical_timeStamp")
    private Date timeStamp;
    @Column(name="practical_credit")
    private String credit;
    @Column(name="practical_ese")
    private String ese;
    @Column(name="practical_grade")
    private String grade;
    @Column(name="practical_ia")
    private String ia;
    @Column(name="practical_regNo")
    private String registrationNo;
    @Column(name="practical_sem")
    private String sem;
    @Column(name="practical_subCode")
    private String subCode;
    @Column(name="practical_subName")
    private String subName;
    @Column(name="practical_total")
    private String total;
    @Column(name="practical_year")
    private String year;



}
