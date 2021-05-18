package com.collegemanagementsystem.Service.interfaceClass;

import com.collegemanagementsystem.Dto.CollegeDetailsDto;
import com.collegemanagementsystem.Dto.PrincipalDto;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.CollegeDetails;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.PrincipalDetails;

import java.util.List;
import java.util.Map;

public interface PrincipalService {
    Map<String,String> save(PrincipalDto principalDto);
    public List<PrincipalDto> principalList();
    PrincipalDetails findPrincipal(String id);
}
