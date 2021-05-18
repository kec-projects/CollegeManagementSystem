package com.collegemanagementsystem.Service.implementation;

import com.collegemanagementsystem.Dto.RoleDto;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.Role;
import com.collegemanagementsystem.Repository.RoleRepository;
import com.collegemanagementsystem.Service.interfaceClass.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Map save(RoleDto role) {
        Map<String,String> msg=new HashMap();
        Role existing= roleRepository.getRoleByName(role.getName());
        if(existing==null){
        Role newrole=new Role();
        newrole.setName(role.getName());
        roleRepository.save(newrole);
            msg.put("status","Successfully");
            msg.put("message","Role successfully added");}
        else{
            msg.put("status","Failed");
            msg.put("message","Role already present");
        }
        return msg;
    }

    @Override
    public List<RoleDto> allRole() {
        return null;
    }
}
