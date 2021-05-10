package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.UserLoginDto;
import com.collegemanagementsystem.Dto.UserRegistrationDto;
import com.collegemanagementsystem.Dto.UserRoleDto;
import com.collegemanagementsystem.Entity.Role;
import com.collegemanagementsystem.Entity.User;
import com.collegemanagementsystem.Entity.UserRole;
import com.collegemanagementsystem.Repository.RoleRepository;
import com.collegemanagementsystem.Repository.StudentAdmissionRepository;
import com.collegemanagementsystem.Repository.UserRepository;
import com.collegemanagementsystem.Repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private StudentAdmissionRepository studentAdmissionRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    ModelMapper modelMapper;


    public User findById(String email) {
        return userRepository.findById(email);
    }


    @Override
    public Map save(UserRegistrationDto registration) {

        Map<String, String> msg = new HashMap();
        User existing = findByEmail(registration.getEmail());
        if (existing == null) {
            User newuser = new User();
            newuser.setName(registration.getName());
            newuser.setEmail(registration.getEmail());
            newuser.setPassword(passwordEncoder.encode(registration.getPassword()));
            if ((studentAdmissionRepository.getStudent(registration.getName(), registration.getEmail())) != null) {
                newuser.setAccountStatus("Active");
            } else {
                newuser.setAccountStatus("Pending");
            }
            newuser.setRegisteredOn(registration.getRegisteredOn());
            User saveUser = userRepository.save(newuser);
            if (newuser.getAccountStatus() == "Active") {
                msg.put("status", "Successful");
                msg.put("message", "Account Successfully  registered and activated");
                UserRole userRole = new UserRole();
                userRole.setUserid(saveUser.getUserId());
                userRole.setRole_name(registration.getYouAre());
                userRoleRepository.save(userRole);

            } else {
                msg.put("status", "Pending");
                msg.put("message", "Account verification needed");
            }

        } else {
            msg.put("status", "Failed");
            msg.put("message", "Account already exists");
        }
        return msg;
    }


    @Override
    public List<UserRegistrationDto> allUser() {
        List<UserRegistrationDto> userRegistrationDto = null;
        List<User> user = userRepository.findAll();
        Type targetListType = new TypeToken<List<User>>() {
        }.getType();
        userRegistrationDto = modelMapper.map(user, targetListType);
        return userRegistrationDto;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }


    @Override
    public Map login(UserLoginDto userLoginDto) {
        User user = userRepository.findByEmail(userLoginDto.getEmail());
        Map msg = new HashMap();
        if (user == null) {
            msg.put("status", "Error");
            msg.put("message", "Username not found");
        } else {
            if (passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
                msg.put("status", "Success");
                msg.put("message", "Authentication successful");
                msg.put("name", user.getName());
                msg.put("userId",user.getUserId());
                msg.put("accountStatus", user.getAccountStatus());
                msg.put("email", user.getEmail());
                msg.put("role",userRoleService.allRole(user.getUserId()));

            } else {
                msg.put("status", "Failed");
                msg.put("message", "Incorrect username or password");
            }
        }
        return msg;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

