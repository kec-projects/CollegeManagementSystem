package com.collegemanagementsystem.Service.implementation;

import com.collegemanagementsystem.Dto.UserRegistrationDto;
import com.collegemanagementsystem.Entity.ProfileImageEntity;
import com.collegemanagementsystem.Entity.User;
import com.collegemanagementsystem.Entity.UserRole;
import com.collegemanagementsystem.Repository.*;
import com.collegemanagementsystem.Service.ProfileImageService;
import com.collegemanagementsystem.Service.interfaceClass.UserRoleService;
import com.collegemanagementsystem.Service.interfaceClass.UserService;
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
    private ProfileImageRepository profileImageRepository;
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
            newuser.setYouAre(registration.getYouAre());
            newuser.setPassword(passwordEncoder.encode(registration.getPassword()));
            if ((studentAdmissionRepository.getStudent(registration.getName(), registration.getEmail())) != null) {
                newuser.setAccountStatus("Active");
            } else {
                newuser.setAccountStatus("Pending");
            }
            Long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            newuser.setRegisteredDate(date);
            User saveUser = userRepository.save(newuser);
            if (newuser.getAccountStatus() == "Active") {
                msg.put("status", "Successful");
                msg.put("message", "Account Successfully  registered and activated");
                UserRole userRole = new UserRole();
                userRole.setUserId(saveUser.getUserId());
                userRole.setRoleName(registration.getYouAre());
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
        return userRepository.findByEmail(email);
    }


    @Override
    public Map loginsuccess(String email) {
        User user = userRepository.findByEmail(email);
        ProfileImageEntity profile = profileImageRepository.getById(user.getUserId());

        Map msg = new HashMap();
        msg.put("status", "Success");
        msg.put("message", "Authentication successful");
        msg.put("name", user.getName());
        msg.put("userId", user.getUserId());
        msg.put("accountStatus", user.getAccountStatus());
        msg.put("email", user.getEmail());
        msg.put("youAre",user.getYouAre());
        msg.put("updatedDate", user.getUpdatedDate());
        msg.put("profileImage", (profile != null) ? profile.getPicByte().toString() : null);
        msg.put("role", userRoleService.allRole(user.getUserId()));
        return msg;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), mapRolesToAuthorities(userRoleRepository.getRoleById(user.getUserId())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public Map userCount() {
        Map msg = new HashMap();
        List<User> user = userRepository.getUser("Active");
        msg.put("active", user.size());
        user = userRepository.getUser("Pending");
        msg.put("pending", user.size());
        user = userRepository.getUser("Closed");
        msg.put("closed", user.size());
        user = userRepository.getUser("Suspended");
        msg.put("suspended", user.size());
        user = userRepository.findAll();
        msg.put("total", user.size());
        return msg;
    }

    @Override
    public List<UserRegistrationDto> getUserStatusBased(String status) {
        List newList = new ArrayList();
        List<User> user = userRepository.getUser(status);
        for (User eachUser : user) {
            Map msg = new HashMap();
            msg.put("name", eachUser.getName());
            msg.put("email", eachUser.getEmail());
            msg.put("youAre", eachUser.getYouAre());
            msg.put("registered On", eachUser.getRegisteredDate());
            newList.add(msg);
        }
        return newList;


    }


}

