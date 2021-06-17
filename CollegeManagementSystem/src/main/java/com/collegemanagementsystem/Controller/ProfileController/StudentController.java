package com.collegemanagementsystem.Controller.ProfileController;

import com.collegemanagementsystem.Dto.StudentDto;
import com.collegemanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService StudentService;

    @GetMapping("/findStudent")
    public List<StudentDto> getAllTopics(){
        return StudentService.get();
    }

    @GetMapping("/findbyid/{UserId}")
    public StudentDto FindById(@PathVariable(value = "UserId")Long UserId){
       return StudentService.FindById (UserId);
    }

    @GetMapping("/findByEmail")
    public StudentDto FindByEmail(@RequestParam String email){
        return StudentService.FindByEmail(email);
    }

    @DeleteMapping("/deletebyid/{UserId}")
    public Map DeleteById(@PathVariable(value = "UserId")Long UserId){
        return StudentService.delete(UserId);
    }

    @PostMapping("/addstudent")
    public Map add(@RequestBody StudentDto student){
        return StudentService.add(student);
    }

    @GetMapping("/getreg/{sem}")
    public List getreg(@PathVariable(value = "sem") String sem){
        return StudentService.getRegistrationNo(sem);
    }

}
