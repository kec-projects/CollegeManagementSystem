package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.FacultyDto;
import com.collegemanagementsystem.Entity.profileEntity.Faculty;
import com.collegemanagementsystem.Repository.FacultyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository repo;

    public List<FacultyDto> get() {
        ModelMapper mapper= new ModelMapper();
        List<Faculty> faculty=(List<Faculty>) repo.findAll();
        return  faculty.stream().map(x-> mapper.map(x, FacultyDto.class)).collect(Collectors.toList());
    }

    public FacultyDto FindById(Long UserID) {
        ModelMapper mapper= new ModelMapper();
        Faculty orElse = repo.findById(UserID).orElse(null);
        return mapper.map(orElse, FacultyDto.class);
    }

    public FacultyDto add(FacultyDto faculty){
        ModelMapper mapper= new ModelMapper();
        Faculty faculties = mapper.map(faculty, Faculty.class);
        repo.save(faculties);
        return mapper.map(faculties, FacultyDto.class);
    }

    public String delete(Long UserID){
        repo.deleteById(UserID);
        return "deleted";
    }
}
