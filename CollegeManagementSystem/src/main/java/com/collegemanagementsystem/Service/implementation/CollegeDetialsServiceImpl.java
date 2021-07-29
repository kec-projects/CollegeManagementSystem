package com.collegemanagementsystem.Service.implementation;

import com.collegemanagementsystem.Dto.CollegeDetailsDto;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.CollegeDetails;
import com.collegemanagementsystem.Repository.CollegeRepository;
import com.collegemanagementsystem.Service.interfaceClass.CollegeDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollegeDetialsServiceImpl implements CollegeDetailsService {
    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Map save(CollegeDetailsDto collegeDetailsDto) {
        Map<String, String> msg = new HashMap();
        CollegeDetails existing = collegeRepository.findCollege(collegeDetailsDto.getId());
        if (existing == null) {
            CollegeDetails newCollege = new CollegeDetails();
            newCollege.setId(collegeDetailsDto.getId());
            newCollege.setName(collegeDetailsDto.getName());
            newCollege.setAddress(collegeDetailsDto.getAddress());
            Date date=Date.valueOf(collegeDetailsDto.getEstablished());
            newCollege.setEstablished(date);
            newCollege.setAffiliationTo(collegeDetailsDto.getAffiliationTo());
            newCollege.setPhone(collegeDetailsDto.getPhone());
            collegeRepository.save(newCollege);
            msg.put("status", "Successfully");
            msg.put("message", "College successfully added");
        } else {
            msg.put("status", "Failed");
            msg.put("message", "College already present");
        }
        return msg;

    }

    @Override
    public List<CollegeDetailsDto> collegeList() {
        List<CollegeDetailsDto> collegeDetailsDto = null;
        List<CollegeDetails> college = collegeRepository.findAll();
        Type targetListType = new TypeToken<List<CollegeDetails>>() {
        }.getType();
        collegeDetailsDto = modelMapper.map(college, targetListType);
        return collegeDetailsDto;
    }

    @Override
    public CollegeDetails findById(Long id) {
        return collegeRepository.findCollege(id);
    }
}
