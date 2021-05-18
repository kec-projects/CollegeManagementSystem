package com.collegemanagementsystem.Service.interfaceClass;

import com.collegemanagementsystem.Dto.CollegeDetailsDto;
import com.collegemanagementsystem.Dto.UserRegistrationDto;
import com.collegemanagementsystem.Entity.User;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.CollegeDetails;

import java.util.List;
import java.util.Map;

public interface CollegeDetailsService {

    Map save(CollegeDetailsDto collegeDetailsDto);
    public List<CollegeDetailsDto> collegeList();
    CollegeDetails findById(Long id);
}
