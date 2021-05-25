package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.StudentDto;
import com.collegemanagementsystem.Entity.profileEntity.Student;
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

    public StudentDto FindById(Long UserId) {
        ModelMapper mapper= new ModelMapper();
        Student orElse = repo.findById(UserId).orElse(null);
        return mapper.map(orElse, StudentDto.class);
    }

    public StudentDto add(StudentDto student){
        ModelMapper mapper= new ModelMapper();
        Student students = mapper.map(student,Student.class);
        repo.save(students);
        return mapper.map(students, StudentDto.class);
    }

    public String delete(Long UserId){
        repo.deleteById(UserId);
        return "deleted";
    }
}
