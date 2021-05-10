package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.NonTeachingStaffDto;
import com.collegemanagementsystem.Entity.NonTeachingStaff;
import com.collegemanagementsystem.Repository.NonTeachingStaffRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NonTeachingStaffService {

    @Autowired
    private NonTeachingStaffRepository repository;


    public List<NonTeachingStaffDto> get() {
        ModelMapper mapper= new ModelMapper();
        List<NonTeachingStaff> nonteachingstaff=(List<NonTeachingStaff>) repository.findAll();
        return  nonteachingstaff.stream().map(x-> mapper.map(x, NonTeachingStaffDto.class)).collect(Collectors.toList());
    }

    public NonTeachingStaffDto FindById(long UserID) {
        ModelMapper mapper= new ModelMapper();
        NonTeachingStaff orElse = repository.findById(UserID).orElse(null);
        return mapper.map(orElse, NonTeachingStaffDto.class);
    }

    public NonTeachingStaffDto add(NonTeachingStaffDto nonteachingstaff){
        ModelMapper mapper= new ModelMapper();
        NonTeachingStaff Nonteachingstaff = mapper.map(nonteachingstaff, NonTeachingStaff.class);
        repository.save(Nonteachingstaff);
        return mapper.map(Nonteachingstaff, NonTeachingStaffDto.class);
    }

    public String delete(long UserID){
        repository.deleteById(UserID);
        return "deleted";
    }
}
