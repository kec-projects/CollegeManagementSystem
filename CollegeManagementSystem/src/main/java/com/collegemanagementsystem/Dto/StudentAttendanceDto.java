package com.collegemanagementsystem.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentAttendanceDto {
    private Long classId;
    private List presentStudent;
    private List absentStudent;
    private String semester;

}


