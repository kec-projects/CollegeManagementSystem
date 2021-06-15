package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.StudentDto;
import com.collegemanagementsystem.Entity.UserRole;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import com.collegemanagementsystem.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;
    @Autowired
    ModelMapper mapper;

    public List<StudentDto> get() {

        List<Student> student=(List<Student>) repo.findAll();
        return  student.stream().map(x-> mapper.map(x, StudentDto.class)).collect(Collectors.toList());
    }

    public StudentDto FindById(Long UserId) {
        Student student = repo.getById(UserId);
        return mapper.map(student, StudentDto.class);
    }

    public StudentDto add(StudentDto student){
        Student students = mapper.map(student,Student.class);
        repo.save(students);
        return mapper.map(students, StudentDto.class);
    }

    public String delete(Long UserId){
        repo.deleteById(UserId);
        return "deleted";
    }

    public List getRegistrationNo(String sem) {
        List<Student> registrationNo= repo.getRegistrationNo(sem);
        List<String> regNo=new ArrayList<>();
        for (Student newRegNo: registrationNo){
            regNo.add(newRegNo.getRegistrationNo());
        }
        return regNo;
    }
}
