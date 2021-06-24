package com.collegemanagementsystem.Entity.collegeDetailsEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="Principal")
public class PrincipalDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Principal_sr")
    private Long sr;
    @Column(name="Principal_name")
    private String name;
    @Id
    @Column(name="Principal_id")
    private String id;
    @Column(name="Principal_joinDate")
    private Date startDate;
    @Column(name="Principal_resignDate")
    private Date endDate;
}
