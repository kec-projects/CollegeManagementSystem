package com.collegemanagementsystem.Controller.CollegeController;

import com.collegemanagementsystem.Dto.DepartmentDto;
import com.collegemanagementsystem.Service.interfaceClass.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/college/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public Map addDepartment(@RequestBody @Valid DepartmentDto departmentDto)
    {
        return departmentService.save(departmentDto);
    }
    @RequestMapping(value="/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<DepartmentDto> getDepartment()
    {
        return departmentService.findAll();
    }

}