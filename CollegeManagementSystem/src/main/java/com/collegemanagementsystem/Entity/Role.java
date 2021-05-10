package com.collegemanagementsystem.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "roleid_gen")
    @SequenceGenerator(name="roleid_gen",initialValue = 100,allocationSize = 10)
    private Integer id;
    private String name;

    public Role(String name) {
        this.name = name;
    }
    public Role(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
