package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.RoleDto;
import com.collegemanagementsystem.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public Map addRole(@RequestBody @Valid RoleDto roleDto){
        return roleService.save(roleDto);

    }
}

