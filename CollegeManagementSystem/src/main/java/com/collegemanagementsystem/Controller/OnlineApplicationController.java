package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.OnlineApplicationDto;
import com.collegemanagementsystem.Dto.OnlineApplicationResponseDto;
import com.collegemanagementsystem.Service.OnlineApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OnlineApplicationController {

    @Autowired
    private OnlineApplicationService onlineApplicationService;

    @PostMapping("/application")
    public OnlineApplicationDto add(@RequestBody OnlineApplicationDto onlineApplication){
        return onlineApplicationService.addDto(onlineApplication);
    }
    @PutMapping(value = "/updateStatus")
    public String updateStatus(@RequestParam  String oldstatus,@RequestParam  String newstatus, @RequestParam Long applicationId){
        return onlineApplicationService.update(oldstatus,newstatus, applicationId);
    }
    @GetMapping("/allapplication")
    public List<OnlineApplicationResponseDto> getallTopics(){
        return onlineApplicationService.get();
    }

    @GetMapping("/applicationbyid/{UserID}")
    public List<OnlineApplicationResponseDto> FindById(@PathVariable(value = "UserID")long UserID){
        return onlineApplicationService.FindById(UserID);
    }
    @GetMapping("/get/application")
    public OnlineApplicationDto getByIdAndCertificate(@RequestParam long UserId, @RequestParam String type){
        return onlineApplicationService.FindByIdAndCertificateType(UserId,type);
    }

    @GetMapping("/statuslist")
    public List<OnlineApplicationDto>getByStatus(@RequestParam String status){
        return onlineApplicationService.getByStatus(status);
    }



}
