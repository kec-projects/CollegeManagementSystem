package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.OnlineApplicationDto;
import com.collegemanagementsystem.Dto.OnlineApplicationResponseDto;
import com.collegemanagementsystem.Dto.OnlineApplicationTypeDto;
import com.collegemanagementsystem.Entity.OnlineApplicationType;
import com.collegemanagementsystem.Service.OnlineApplicationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OnlineApplicationTypeController {
    @Autowired
    private OnlineApplicationTypeService OnlineApplicationTypeService;

    @PostMapping("/applicationtype")
    public OnlineApplicationTypeDto add(@RequestBody OnlineApplicationTypeDto onlineApplication) {
        return OnlineApplicationTypeService.addapplication(onlineApplication);
    }

    @GetMapping("/allapplicationtype")
    public List<OnlineApplicationTypeDto> get() {
        return OnlineApplicationTypeService.get();
    }

    @GetMapping("/applicationypebyname/{applicationTypeName}")
    public List<OnlineApplicationTypeDto> FindById(@PathVariable(value = "applicationTypeName") String applicationTypeName) {
        return OnlineApplicationTypeService.FindById(applicationTypeName);
    }

    @DeleteMapping("/deleteapplicationbyname/{applicationTypeName}")
    public String DeleteById(@PathVariable(value = "applicationTypeName")String applicationTypeName){
        return OnlineApplicationTypeService.delete(applicationTypeName);
    }
}
