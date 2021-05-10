package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.UserRoleDto;
import com.collegemanagementsystem.Entity.UserRole;
import com.collegemanagementsystem.Repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
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
        UserRole userRole= userRoleRepository.checkRole(userRoleDto.getUserid(),userRoleDto.getRole_name());
        if(userRole==null){
            UserRole userRole1=new UserRole();
            userRole1.setRole_name(userRoleDto.getRole_name());
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
    public List<UserRoleDto> allRole(Integer uid) {
        List<UserRoleDto> userRoleDto =null;
        List<UserRole> userRole = ((userRoleRepository.getRoleById(uid)));
        System.out.println(userRole);
        Type targetListType= new TypeToken<List<UserRole>>(){}.getType();
        userRoleDto =modelMapper.map(userRole,targetListType);
        return userRoleDto;
    }
}
