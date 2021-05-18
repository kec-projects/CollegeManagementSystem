package com.collegemanagementsystem.Controller.ProfileController;

import com.collegemanagementsystem.Dto.FacultyDto;
import com.collegemanagementsystem.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {

    @Autowired
    private FacultyService FacultyService;

    @GetMapping("/findfaculty")
    public List<FacultyDto> getAllTopics(){
        return FacultyService.get();
    }

    @GetMapping("/findfacultybyid/{UserId}")
    public FacultyDto FindById(@PathVariable(value = "UserId")Long UserId){
        return FacultyService.FindById (UserId);
    }

    @PostMapping("/addfaculty")
    public FacultyDto add(@RequestBody FacultyDto faculty){
        return FacultyService.add(faculty);
    }

    @DeleteMapping("/deletefacultybyid/{UserId}")
    public String DeleteById(@PathVariable(value = "UserId")Long UserId){
        return FacultyService.delete(UserId);
    }

}
