package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.OnlineApplicationDto;
import com.collegemanagementsystem.Dto.OnlineApplicationResponseDto;
import com.collegemanagementsystem.Entity.OnlineApplication;
import com.collegemanagementsystem.Repository.OnlineApplicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public OnlineApplicationDto addDto(OnlineApplicationDto dto) {
        OnlineApplication onlineApplications = mapper.map(dto, OnlineApplication.class);
        Long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        onlineApplications.setAppliedDate(date);
        repo.save(onlineApplications);
        System.out.println(onlineApplications);
        return mapper.map(onlineApplications, OnlineApplicationDto.class);
    }

    public OnlineApplicationDto FindByIdAndCertificateType(long UserId,String type){
        OnlineApplication application = repo.findByIdAndCertificate(UserId,type);
        return mapper.map(application, OnlineApplicationDto.class);
    }

    public List<OnlineApplicationResponseDto> get(){
        List<OnlineApplication> onlineApplications = (List<OnlineApplication>) repo.findAll();
        return onlineApplications.stream().map(x->mapper.map(x, OnlineApplicationResponseDto.class)).collect(Collectors.toList());
    }

    public List<OnlineApplicationResponseDto> FindById(long UserId){
        List<OnlineApplication> applications = repo.getById(UserId);
        return applications.stream().map(x->mapper.map(x,OnlineApplicationResponseDto.class)).collect(Collectors.toList());
    }

    public List<OnlineApplicationDto> getByStatus(String status){
        List<OnlineApplication> application = repo.getByStatus(status);
        return application.stream().map(x->mapper.map(x,OnlineApplicationDto.class)).collect(Collectors.toList());

    }

    public void upload(MultipartFile file,Long apid)  {
        OnlineApplication onlineApplication = new OnlineApplication();
        try {
            onlineApplication.setFile(file.getBytes());
            repo.updatedDetails(onlineApplication.getFile(),apid);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public OnlineApplication downloadFile(Long applicationId){
        OnlineApplication onlineApplication = repo.getOne(applicationId);
        return onlineApplication;
    }



}
