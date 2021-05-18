package com.collegemanagementsystem.Service.implementation;

import com.collegemanagementsystem.Dto.DepartmentDto;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.Department;
import com.collegemanagementsystem.Repository.DepartmentRepository;
import com.collegemanagementsystem.Service.interfaceClass.DepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Map<String, String> save(DepartmentDto departmentDto) {
        Map<String, String> msg = new HashMap();
        Department existing = departmentRepository.getDepartment(departmentDto.getId());
        if (existing == null) {
            Department newDepartment = new Department();
            newDepartment.setId(departmentDto.getId());
            newDepartment.setName(departmentDto.getName());
            departmentRepository.save(newDepartment);
            msg.put("status", "Successfully");
            msg.put("message", "Department successfully added");
        } else {
            msg.put("status", "Failed");
            msg.put("message", "Department already present");
        }
        return msg;
        }

    @Override
    public List<DepartmentDto> findAll() {
        List<DepartmentDto> departmentDto = null;
        List<Department> college = departmentRepository.findAll();
        Type targetListType = new TypeToken<List<Department>>() {
        }.getType();
        departmentDto = modelMapper.map(college, targetListType);
        return departmentDto;
    }

}
