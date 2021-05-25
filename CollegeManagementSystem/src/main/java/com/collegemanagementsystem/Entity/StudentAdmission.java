package com.collegemanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Admission")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAdmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Admission_id")
    private Long userId;
    @Column(name="Admission_name")
    private String name;
    @Column(name="Admission_email")
    private String email;
    @Column(name="Admission_mobile")
    private Long mobile;

}
