package com.collegemanagementsystem.Service.implementation;

import com.collegemanagementsystem.Dto.PrincipalDto;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.PrincipalDetails;
import com.collegemanagementsystem.Repository.PrincipalRepository;
import com.collegemanagementsystem.Service.interfaceClass.PrincipalService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrincipalServiceImpl implements PrincipalService {

    @Autowired
    private PrincipalRepository principalRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Map<String, String> save(PrincipalDto principalDto) {
        Map<String, String> msg = new HashMap();
        PrincipalDetails existing = principalRepository.getPrincipal( principalDto.getId());
        if (existing == null) {
            PrincipalDetails newPrincipal = new PrincipalDetails();
            newPrincipal.setName(principalDto.getName());
            newPrincipal.setId(principalDto.getId());
            newPrincipal.setStartDate(principalDto.getStartDate());
            principalRepository.save(newPrincipal);
            msg.put("status", "Successfully");
            msg.put("message", "Principal successfully added");
        } else {
            msg.put("status", "Failed");
            msg.put("message", "Principal Details already present");
        }
        return msg;
    }

    @Override
    public List<PrincipalDto> principalList() {
        List<PrincipalDto> principalDto= null;
        List<PrincipalDetails> college = principalRepository.findAll();
        Type targetListType = new TypeToken<List<PrincipalDetails>>() {
        }.getType();
        principalDto = modelMapper.map(college, targetListType);
        return principalDto;
    }

    @Override
    public PrincipalDetails findPrincipal(String id) {
        return principalRepository.getPrincipal(id);
    }
}

