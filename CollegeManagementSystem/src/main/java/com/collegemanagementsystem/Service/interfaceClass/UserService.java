package com.collegemanagementsystem.Service.interfaceClass;

import com.collegemanagementsystem.Dto.UserRegistrationDto;
import com.collegemanagementsystem.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface UserService extends UserDetailsService {

    Map loginsuccess(String email);
    Map save(UserRegistrationDto registration);
    public List<UserRegistrationDto> allUser();
    User findByEmail(String email);
    User findById(String email);

}
