package com.collegemanagementsystem.Entity.collegeDetailsEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "roleid_gen")
    @SequenceGenerator(name="roleid_gen",initialValue = 100)
    @Column(name="Role_id")
    private Long id;
    @Column(name="Role_name")
    private String name;

    public Role(String name) {
        this.name = name;
    }
    public Role(){}
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

}
