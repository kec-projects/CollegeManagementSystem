package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.UserLoginDto;
import com.collegemanagementsystem.Dto.UserRegistrationDto;
import com.collegemanagementsystem.Dto.UserRoleDto;
import com.collegemanagementsystem.Entity.User;
import com.collegemanagementsystem.Entity.UserRole;
import com.collegemanagementsystem.Service.UserRoleService;
import com.collegemanagementsystem.Service.UserService;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value="/getall",method = RequestMethod.GET)
    @ResponseBody
    public List<UserRegistrationDto> alluser(){

        List<UserRegistrationDto> userRegistrationDtos =userService.allUser();
        return userRegistrationDtos;
    }


    @RequestMapping(value="/getUserRole",method = RequestMethod.POST)
    @ResponseBody
    public List<UserRoleDto> alluserrole( @RequestBody @Valid  UserRoleDto userRoleDto){
        List<UserRoleDto> userRoleDtos =userRoleService.allRole(userRoleDto.getUserid());
        return userRoleDtos;
    }


    @RequestMapping(value="/addUserRole",method = RequestMethod.POST)
    @ResponseBody
    public Map adduserrole(@RequestBody @Valid  UserRoleDto userRoleDto){
        return  userRoleService.save(userRoleDto);
    }


    @RequestMapping(value="/registration",method = RequestMethod.POST)
    @ResponseBody
    public Map adduser(@RequestBody @Valid UserRegistrationDto userRegistrationDto){
        Map msg=new Hashtable();
        User existing = userService.findByEmail(userRegistrationDto.getEmail());
        if (existing != null) {
            msg.put("message","Email already exist");
            msg.put("status","Registration Failed");
            return msg;
        }
        return userService.save(userRegistrationDto);
    }
    @RequestMapping(value="/login",method = RequestMethod.POST)

    @ResponseBody
    public Map login( @RequestBody @Valid UserLoginDto userLoginDto){

        return  userService.login(userLoginDto);
    }

}
