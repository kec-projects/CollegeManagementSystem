package com.collegemanagementsystem.Entity.ResultEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="resultTheory")
@Getter
@Setter
public class TheoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="theory_sr")
    private Long sr;
    @Column(name="theory_timeStamp")
    private Date timeStamp;
    @Column(name="theory_credit")
    private String credit;
    @Column(name="theory_ese")
    private String ese;
    @Column(name="theory_grade")
    private String grade;
    @Column(name="theory_ia")
    private String ia;
    @Column(name="theory_regNo")
    private String registrationNo;
    @Column(name="theory_sem")
    private String sem;
    @Column(name="theory_subCode")
    private String subCode;
    @Column(name="theory_subName")
    private String subName;
    @Column(name="theory_total")
    private String total;
    @Column(name="theory_year")
    private String year;
}
