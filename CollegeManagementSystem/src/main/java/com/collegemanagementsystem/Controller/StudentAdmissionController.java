package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.StudentAdmissionDto;
import com.collegemanagementsystem.Service.interfaceClass.StudentAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/admission")
public class StudentAdmissionController {
    @Autowired
    private StudentAdmissionService studentAdmissionService;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public Map addStudent( @RequestBody @Valid StudentAdmissionDto studentAdmissionDto){
        return studentAdmissionService.add(studentAdmissionDto);

    }
}
