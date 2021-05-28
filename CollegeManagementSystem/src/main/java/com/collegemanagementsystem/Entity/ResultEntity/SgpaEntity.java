package com.collegemanagementsystem.Entity.ResultEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Table(name="sgpa")
public class SgpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sgpa_sr")
    private Long sr;
    @Column(name = "sgpa_reg")
    private String reg;
    @Column(name = "sgpa_sem")
    private String sem;
    @Column(name = "sgpa_sgpa")
    private String sgpa;
    @Column(name = "sgpa_year")
    private String year;
    @Column(name = "sgpa_timeStamp")
    private Date timeStamp;

}
