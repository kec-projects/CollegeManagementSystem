package com.collegemanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ApplicationType")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OnlineApplicationType {
    @Id
    @GeneratedValue
    private Long applicationTypeId;
    private String applicationTypeName;
}
