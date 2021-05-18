package com.collegemanagementsystem.Controller.ProfileController;

import com.collegemanagementsystem.Dto.NonTeachingStaffDto;
import com.collegemanagementsystem.Service.NonTeachingStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NonTeachingStaffController {

    @Autowired
    private NonTeachingStaffService NonTeachingStaffService;

    @GetMapping("/findStaff")
    public List<NonTeachingStaffDto> getAllTopics(){
        return NonTeachingStaffService.get();
    }

    @GetMapping("/findstaffbyid/{UserId}")
    public NonTeachingStaffDto FindById(@PathVariable(value = "UserId")Long UserId){
        return NonTeachingStaffService.FindById (UserId);
    }

    @DeleteMapping("/deletestaffbyid/{UserId}")
    public String DeleteById(@PathVariable(value = "UserId")Long UserId){
        return NonTeachingStaffService.delete(UserId);
    }

    @PostMapping("/addstaff")
    public NonTeachingStaffDto add(@RequestBody NonTeachingStaffDto nonteachingstaff){
        return NonTeachingStaffService.add(nonteachingstaff);
    }
}
