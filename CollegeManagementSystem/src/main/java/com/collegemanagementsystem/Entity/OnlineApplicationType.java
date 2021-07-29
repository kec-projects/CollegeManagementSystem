package com.collegemanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ApplicationType")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OnlineApplicationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationTypeId;
    private String applicationTypeName;
}
