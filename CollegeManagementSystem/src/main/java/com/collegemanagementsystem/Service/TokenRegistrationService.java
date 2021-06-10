package com.collegemanagementsystem.Service;
import com.collegemanagementsystem.Dto.TokenRegistrationDTO;
import com.collegemanagementsystem.Entity.TokenRegistration;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import com.collegemanagementsystem.Repository.StudentRepository;
import com.collegemanagementsystem.Repository.TokenRegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenRegistrationService {

    @Autowired
    public TokenRegistrationRepository studentDao;
    @Autowired
    public StudentRepository studentservice;
    @Autowired
    ModelMapper mapper;

    public TokenRegistrationDTO addToken(TokenRegistrationDTO dto) {
        TokenRegistration student= mapper.map(dto, TokenRegistration.class);
        studentDao.save(student);
        return mapper.map(student, TokenRegistrationDTO.class);
    }

    public List<TokenRegistration> getToken(String registration){
        Student student= studentservice.RegistrationNo(registration);
        if(student==null){
            return null;
        }
        Long uid= student.getUserId();
        List<TokenRegistration> getToken =  studentDao.getById(uid);
        return getToken;

    }

    public String delete(){
        studentDao.deleteAll();
        return "All data deleted";
    }

    public String deleteById(Long uid){
        studentDao.deleteById(Math.toIntExact(uid));
        return "deleted";
    }


}