package com.collegemanagementsystem.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Session")
@Getter
@Setter
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Session_id")
    private Long sessionId;
    @Column(name="Session_createdDate")
    private Date createDate;
    @Column(name="Session_expiryDate")
    private Date expiryDate;

}
