package com.collegemanagementsystem.Service;
import com.collegemanagementsystem.Dto.StudentDto;
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
    public TokenRegistrationRepository tokenRegistrationRepository;
    @Autowired
    public StudentRepository studentservice;
    @Autowired
    ModelMapper mapper;

    public void addToken(TokenRegistrationDTO dto) {
        TokenRegistration tokens= mapper.map(dto, TokenRegistration.class);
        List<TokenRegistration> tokensofid= tokenRegistrationRepository.getById(dto.getUserId());
        for(TokenRegistration newToken: tokensofid){
            if (dto.getDeviceId()==newToken.getDeviceId()){
                return ;
            }
        }
        tokenRegistrationRepository.save(tokens);

    }

    public List<TokenRegistrationDTO> getToken(String registration){
        Student student= studentservice.RegistrationNo(registration);
        if(student==null){
            return null;
        }
        Long uid= student.getUserId();
        List<TokenRegistration> getToken =  tokenRegistrationRepository.getById(uid);
        return getToken.stream().map(x-> mapper.map(x, TokenRegistrationDTO.class)).collect(Collectors.toList());

    }

    public void delete(){
        tokenRegistrationRepository.deleteAll();
        return;
    }

    public void deleteById(Long uid){
        tokenRegistrationRepository.deleteById(Math.toIntExact(uid));
        return ;
    }


}