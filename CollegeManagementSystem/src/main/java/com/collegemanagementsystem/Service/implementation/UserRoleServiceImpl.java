package com.collegemanagementsystem.Service.implementation;

import com.collegemanagementsystem.Dto.UserRoleDto;
import com.collegemanagementsystem.Entity.UserRole;
import com.collegemanagementsystem.Repository.UserRoleRepository;
import com.collegemanagementsystem.Service.interfaceClass.UserRoleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Map save(UserRoleDto userRoleDto) {
        Map<String,String> msg=new HashMap();
        UserRole userRole= userRoleRepository.checkRole(userRoleDto.getUserid(),userRoleDto.getRoleName());
        if(userRole==null){
            UserRole userRole1=new UserRole();
            userRole1.setRoleName(userRoleDto.getRoleName());
            userRole1.setUserid(userRoleDto.getUserid());
            userRoleRepository.save(userRole1);
            msg.put("status","Successful");
            msg.put("message","User Role Relation Added Successfully");
        }
        else{
            msg.put("status","Failed");
            msg.put("message","Relations already exists");

        }
        return msg;
    }

    @Override
    public List<UserRoleDto> allRole(Long userId) {
        List<UserRoleDto> userRoleDto =null;
        Map userRoles=null;
        List<UserRole> userRole = ((userRoleRepository.getRoleById(userId)));
        Type targetListType= new TypeToken<List<UserRole>>(){}.getType();
        userRoleDto =modelMapper.map(userRole,targetListType);
        int size=userRoleDto.size();

        return userRoleDto;
    }
}
