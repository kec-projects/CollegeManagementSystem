package com.collegemanagementsystem.Service.interfaceClass;

import com.collegemanagementsystem.Dto.DepartmentDto;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Map<String,String> save(DepartmentDto departmentDto);
    List<DepartmentDto> findAll();
}
