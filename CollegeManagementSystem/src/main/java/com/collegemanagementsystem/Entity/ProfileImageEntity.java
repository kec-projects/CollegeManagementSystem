package com.collegemanagementsystem.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "profileImage")

public class ProfileImageEntity {

    @Column(name = "sr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sr;
    @Id
    @Column(name = "UserId")
    private Long userId;

    @Lob
    @Column(name = "picByte",columnDefinition="mediumblob")
    private byte[] picByte;

}
