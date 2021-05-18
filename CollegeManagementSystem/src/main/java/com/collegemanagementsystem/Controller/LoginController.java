package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.UserLoginDto;
import com.collegemanagementsystem.Service.interfaceClass.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public UserDetails login(@RequestBody @Valid UserLoginDto userLoginDto) {

        return userService.loadUserByUsername(userLoginDto.getEmail());
    }


}
