package com.collegemanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="Admission")
public class StudentAdmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Admission_id")
    private Long id;
    @Column(name="Admission_name")
    private String name;
    @Column(name="Admission_email")
    private String email;
    @Column(name="Admission_mobile")
    private Long mobile;

    public StudentAdmission() {
    }

    public StudentAdmission(Long id, String name, String email, Long mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }
}
