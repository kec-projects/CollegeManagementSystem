package com.collegemanagementsystem.Controller.CollegeController;

import com.collegemanagementsystem.Dto.RoleDto;
import com.collegemanagementsystem.Service.interfaceClass.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/college/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public Map addRole(@RequestBody @Valid RoleDto roleDto){
        return roleService.save(roleDto);

    }
}

