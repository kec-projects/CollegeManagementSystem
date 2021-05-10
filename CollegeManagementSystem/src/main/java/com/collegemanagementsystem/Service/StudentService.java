package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.StudentDto;
import com.collegemanagementsystem.Entity.Student;
import com.collegemanagementsystem.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;


    public List<StudentDto> get() {
        ModelMapper mapper= new ModelMapper();
        List<Student> student=(List<Student>) repo.findAll();
        return  student.stream().map(x-> mapper.map(x, StudentDto.class)).collect(Collectors.toList());
    }

    public StudentDto FindById(long UserID) {
        ModelMapper mapper= new ModelMapper();
        Student orElse = repo.findById(UserID).orElse(null);
        return mapper.map(orElse, StudentDto.class);
    }

    public StudentDto add(StudentDto student){
        ModelMapper mapper= new ModelMapper();
        Student students = mapper.map(student,Student.class);
        repo.save(students);
        return mapper.map(students, StudentDto.class);
    }

    public String delete(long UserID){
        repo.deleteById(UserID);
        return "deleted";
    }
}
