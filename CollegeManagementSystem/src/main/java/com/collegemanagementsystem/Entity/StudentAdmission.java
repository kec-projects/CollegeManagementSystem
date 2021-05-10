package com.collegemanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="Student_Admission")
public class StudentAdmission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;
    private String name;
    private String email;
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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


}
