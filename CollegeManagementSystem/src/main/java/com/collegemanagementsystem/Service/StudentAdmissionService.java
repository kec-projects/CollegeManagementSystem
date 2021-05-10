package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.RoleDto;
import com.collegemanagementsystem.Dto.StudentAdmissionDto;
import com.collegemanagementsystem.Entity.StudentAdmission;


import java.util.List;
import java.util.Map;

public interface StudentAdmissionService {
    StudentAdmission findStudent(String email, String name);
    Map add(StudentAdmissionDto studentAdmissionDto);
    public List<StudentAdmissionDto> allstudent();
}
