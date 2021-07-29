package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.OnlineApplicationDto;
import com.collegemanagementsystem.Dto.OnlineApplicationResponseDto;
import com.collegemanagementsystem.Entity.OnlineApplication;
import com.collegemanagementsystem.Repository.OnlineApplicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnlineApplicationService {

    @Autowired
    private OnlineApplicationRepository repo;

    @Autowired
    ModelMapper mapper;


    public String  update(String oldstatus,String newstatus, Long applicationId){
        repo.updateStatus(oldstatus,newstatus,applicationId);
        if(newstatus=="Approved"){
            Calendar cal= Calendar.getInstance();
            Date date=cal.getTime();
            repo.updateApprovedDate(date);
            System.out.println(date);
        }
        return "Status Updated Successfully";
    }

    public List<OnlineApplicationResponseDto> get(){
        List<OnlineApplication> onlineApplications = (List<OnlineApplication>) repo.findAll();
        return onlineApplications.stream().map(x->mapper.map(x, OnlineApplicationResponseDto.class)).collect(Collectors.toList());
    }

    public List<OnlineApplicationResponseDto> FindById(long UserId){
        List<OnlineApplication> applications = repo.getById(UserId);
        return applications.stream().map(x->mapper.map(x,OnlineApplicationResponseDto.class)).collect(Collectors.toList());
    }
    public OnlineApplicationDto FindByIdAndCertificateType(long UserId,String type){
        OnlineApplication application = repo.findByIdAndCertificate(UserId,type);
        application.setFile(Base64.getEncoder().encode(application.getFile()));
        return mapper.map(application, OnlineApplicationDto.class);
    }

    public OnlineApplicationDto addDto(OnlineApplicationDto dto) {
       OnlineApplication onlineApplications=mapper.map(dto,OnlineApplication.class);
       onlineApplications.setFile(Base64.getDecoder().decode(dto.getFile()));
        repo.save(onlineApplications);
        return mapper.map(onlineApplications,OnlineApplicationDto.class);
    }
    public List<OnlineApplicationDto> getByStatus(String status){
        List<OnlineApplication> application = repo.getByStatus(status);
        return application.stream().map(x->mapper.map(x,OnlineApplicationDto.class)).collect(Collectors.toList());

    }


}
