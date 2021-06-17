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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Department_sr")
    private Long sr;
    @Column(name="Department_id")
    private Long id;
    @Column(name="Department_name")
    private String name;


}
