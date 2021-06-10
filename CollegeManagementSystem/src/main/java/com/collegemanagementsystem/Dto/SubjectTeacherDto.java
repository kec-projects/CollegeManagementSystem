package com.collegemanagementsystem.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class SubjectTeacherDto {
    private Long classId;
    private Long userId;
    private String teacherName;
    private String subName;
    private String sem;
    private String batch;
    private String depart;
    private String flag;
}
