package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.StudentDto;
import com.collegemanagementsystem.Entity.UserRole;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import com.collegemanagementsystem.Repository.StudentRepository;
import com.collegemanagementsystem.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConstantService constantService;

    public List<StudentDto> get() {

        List<Student> student = (List<Student>) repo.findAll();
        return student.stream().map(x -> mapper.map(x, StudentDto.class)).collect(Collectors.toList());
    }

    public StudentDto FindById(Long UserId) {
        Student student = repo.getById(UserId);
        return mapper.map(student, StudentDto.class);
    }

    public StudentDto FindByEmail(String email) {
        Student student = repo.getByEmail(email);
        return mapper.map(student, StudentDto.class);
    }

    public Map add(StudentDto student) {
        Student students = mapper.map(student, Student.class);
        repo.save(students);
        userRepository.updateDate(constantService.getLocalDate(), student.getUserId());
        Map msg = new HashMap();
        msg.put("Status", "Successful");
        msg.put("Message", "Data saved successful");
        return msg;
    }

    public Map delete(Long UserId) {
        repo.deleteById(UserId);
        Map msg = new HashMap();
        msg.put("Status", "Successful");
        msg.put("Message", "Data deleted successful");
        return msg;
    }

    public List getRegistrationNo(String sem) {
        List<Student> registrationNo = repo.getRegistrationNo(sem);
        List<String> regNo = new ArrayList<>();
        for (Student newRegNo : registrationNo) {
            regNo.add(newRegNo.getRegistrationNo());
        }
        return regNo;
    }

    public List getUserId(String sem) {
        List<Student> registrationNo = repo.getRegistrationNo(sem);
        List<Long> userId = new ArrayList<>();
        for (Student newRegNo : registrationNo) {
            userId.add(newRegNo.getUserId());
        }
        return userId;
    }
}
