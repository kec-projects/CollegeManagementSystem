package com.collegemanagementsystem.Entity.collegeDetailsEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Role")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "roleid_gen")
    @SequenceGenerator(name="roleid_gen",initialValue = 100)
    @Column(name="Role_id")
    private Long id;
    @Column(name="Role_name")
    private String name;



}
