package com.collegemanagementsystem.Entity.collegeDetailsEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter

@Table(name="Department")
public class Department {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Department_sr")
    private Long sr;
    @Id
    @Column(name="Department_id")
    private Long id;
    @Column(name="Department_name")
    private String name;


}
