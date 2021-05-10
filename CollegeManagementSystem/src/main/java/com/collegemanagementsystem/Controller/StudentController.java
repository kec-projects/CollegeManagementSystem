package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.StudentDto;
import com.collegemanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService StudentService;

    @GetMapping("/findStudent")
    public List<StudentDto> getAllTopics(){
        return StudentService.get();
    }

    @GetMapping("/findbyid/{UserId}")
    public StudentDto FindById(@PathVariable(value = "UserId")long UserId){
       return StudentService.FindById (UserId);
    }

    @DeleteMapping("/deletebyid/{UserId}")
    public String DeleteById(@PathVariable(value = "UserId")long UserId){
        return StudentService.delete(UserId);
    }

    @PostMapping("/addstudent")
    public StudentDto add(@RequestBody StudentDto student){
        return StudentService.add(student);
    }


}
