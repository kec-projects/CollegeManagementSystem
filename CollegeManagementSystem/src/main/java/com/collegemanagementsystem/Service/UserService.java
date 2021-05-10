package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.UserLoginDto;
import com.collegemanagementsystem.Dto.UserRegistrationDto;
import com.collegemanagementsystem.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public interface UserService extends UserDetailsService {

    Map login(UserLoginDto userLoginDto);
    Map save(UserRegistrationDto registration);
    public List<UserRegistrationDto> allUser();
    User findByEmail(String email);
    User findById(String email);


}
