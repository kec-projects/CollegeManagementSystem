package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.ProfileImageDto;
import com.collegemanagementsystem.Entity.ProfileImageEntity;
import com.collegemanagementsystem.Repository.ProfileImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileImageService {
    @Autowired
    private ProfileImageRepository profileImageRepository;

    public Map saveImage(ProfileImageDto profileImageDto) throws IOException {
        Map msg=new HashMap();
        ProfileImageEntity exist= profileImageRepository.getById(profileImageDto.getUserId());
        if(exist!=null){
            profileImageRepository.deleteById(profileImageDto.getUserId());
        }
        //byte[] parseBase64Binary = DatatypeConverter.parseBase64Binary((String)profileImageDto.getPicByte());
        ProfileImageEntity profileImageEntity=new ProfileImageEntity();
        profileImageEntity.setUserId(profileImageDto.getUserId());
        profileImageEntity.setPicByte(profileImageDto.getPicByte());
        profileImageRepository.save(profileImageEntity);
        msg.put("status","Successful");
        msg.put("message",(exist==null)?"Profile Image Saved":"Profile Image Updated");
        return msg;
    }
    public Map getImage(Long id){
        Map msg=new HashMap();

        ProfileImageEntity exist= profileImageRepository.getById(id);
        if(exist!=null){

            msg.put("status","Successful");
            msg.put("message","Image Found");
            msg.put("image",exist);
        }
        else{
            msg.put("status","Failed");
            msg.put("message","Image Not Found");
        }
        return msg;
    }

}
