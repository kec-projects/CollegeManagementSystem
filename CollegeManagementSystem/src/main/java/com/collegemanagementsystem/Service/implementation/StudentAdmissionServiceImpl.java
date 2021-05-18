package com.collegemanagementsystem.Service.implementation;

import com.collegemanagementsystem.Dto.StudentAdmissionDto;
import com.collegemanagementsystem.Entity.StudentAdmission;
import com.collegemanagementsystem.Repository.StudentAdmissionRepository;
import com.collegemanagementsystem.Service.interfaceClass.StudentAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentAdmissionServiceImpl implements StudentAdmissionService {
    @Autowired
    StudentAdmissionRepository studentAdmissionRepository;
    @Override
    public StudentAdmission findStudent(String email, String name) {
        return studentAdmissionRepository.getStudent(name,email);


    }

    @Override
    public Map add(StudentAdmissionDto studentAdmissionDto) {
        Map msg=new HashMap();
        StudentAdmission studentAdmission=studentAdmissionRepository.getStudent(studentAdmissionDto.getName(),studentAdmissionDto.getEmail());
        if(studentAdmission==null){
            StudentAdmission newStudent=new StudentAdmission();
            newStudent.setName(studentAdmissionDto.getName());
            newStudent.setEmail(studentAdmissionDto.getEmail());
            newStudent.setMobile(studentAdmissionDto.getMobile());
            studentAdmissionRepository.save(newStudent);
            msg.put("status","Successful");
            msg.put("message","Student Added Successfully");
        }
        else{
            msg.put("status","Failed");
            msg.put("message","Student Already Exists");

        }
        return msg;
    }

    @Override
    public List<StudentAdmissionDto> allstudent() {
        return null;
    }
}
