package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.OnlineApplicationTypeDto;
import com.collegemanagementsystem.Entity.OnlineApplicationType;
import com.collegemanagementsystem.Repository.OnlineApplicationTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnlineApplicationTypeService {

    @Autowired
    private OnlineApplicationTypeRepository repo;

    @Autowired
    ModelMapper mapper;

    public OnlineApplicationTypeDto addapplication(OnlineApplicationTypeDto onlineApplication) {
        OnlineApplicationType onlineApplications = mapper.map(onlineApplication, OnlineApplicationType.class);
        repo.save(onlineApplications);
        return mapper.map(onlineApplications, OnlineApplicationTypeDto.class);
    }

    public List<OnlineApplicationTypeDto> get() {
        List<OnlineApplicationType> onlineApplication = (List<OnlineApplicationType>) repo.findAll();
        return onlineApplication.stream().map(x->mapper.map(x, OnlineApplicationTypeDto.class)).collect(Collectors.toList());
    }

    public List<OnlineApplicationTypeDto> FindById(String applicationTypeName) {
        List<OnlineApplicationType> applicationType = repo.getById(applicationTypeName);
        return applicationType.stream().map(x->mapper.map(x,OnlineApplicationTypeDto.class)).collect(Collectors.toList());
    }

    public String delete(String applicationTypeName) {
        repo.deleteById(applicationTypeName);
        return "deleted";
    }
}
