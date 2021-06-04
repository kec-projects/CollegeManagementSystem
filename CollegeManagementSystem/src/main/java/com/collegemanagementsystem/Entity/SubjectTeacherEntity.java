package com.collegemanagementsystem.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="SubjectTeacherEntity")
@Getter
@Setter
public class SubjectTeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SubTeacher_classId")
    private Long classId;
    @Column(name="SubTeacher_userId")
    private Long userId;
    @Column(name="SubTeacher_teacherName")
    private String teacherName;
    @Column(name="SubTeacher_subjectName")
    private String subName;
    @Column(name="SubTeacher_sem")
    private String sem;
    @Column(name="SubTeacher_batch")
    private String batch;
    @Column(name="SubTeacher_depart")
    private String depart;
    @Column(name="SubTeacher_flag")
    private String flag;









}
