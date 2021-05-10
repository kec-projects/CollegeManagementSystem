package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.StudentAdmissionDto;
import com.collegemanagementsystem.Entity.StudentAdmission;
import com.collegemanagementsystem.Repository.StudentAdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentAdmissionServiceImpl implements StudentAdmissionService{
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
            StudentAdmission studentAdmission1=new StudentAdmission();
            studentAdmission1.setName(studentAdmissionDto.getName());
            studentAdmission1.setEmail(studentAdmissionDto.getEmail());
            studentAdmissionRepository.save(studentAdmission1);
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
