package com.collegemanagementsystem.Service;
import com.collegemanagementsystem.Dto.TokenRegistrationDTO;
import com.collegemanagementsystem.Entity.TokenRegistration;
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
    ModelMapper mapper;

    public TokenRegistrationDTO addToken(TokenRegistrationDTO dto) {
        TokenRegistration student= mapper.map(dto, TokenRegistration.class);
        studentDao.save(student);
        return mapper.map(student, TokenRegistrationDTO.class);
    }

    public List<TokenRegistrationDTO> getToken(Long uid){
        List<TokenRegistration> getToken =  studentDao.getById(uid);
        return getToken.stream().map(x-> mapper.map(x, TokenRegistrationDTO.class)).collect(Collectors.toList());
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