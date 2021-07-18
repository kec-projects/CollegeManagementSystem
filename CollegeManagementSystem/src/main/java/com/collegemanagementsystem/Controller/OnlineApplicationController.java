package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.OnlineApplicationDto;
import com.collegemanagementsystem.Dto.OnlineApplicationResponseDto;
import com.collegemanagementsystem.Entity.OnlineApplication;
import com.collegemanagementsystem.Service.OnlineApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class OnlineApplicationController {

    @Autowired
    private OnlineApplicationService onlineApplicationService;

    @PostMapping("/application")
    public OnlineApplicationDto add(@RequestBody OnlineApplicationDto onlineApplication) {
        return onlineApplicationService.addDto(onlineApplication);
    }

    @PutMapping(value = "/updateStatus")
    public String updateStatus(@RequestParam String oldstatus, @RequestParam String newstatus, @RequestParam Long applicationId) {
        return onlineApplicationService.update(oldstatus, newstatus, applicationId);
    }

    @GetMapping("/allapplication")
    public List<OnlineApplicationResponseDto> getallTopics() {
        return onlineApplicationService.get();
    }

    @GetMapping("/applicationbyid/{userID}")
    public List<OnlineApplicationResponseDto> FindById(@PathVariable(value = "userID") long userID) {
        return onlineApplicationService.FindById(userID);
    }

    @GetMapping("/get/application")
    public OnlineApplicationDto getByIdAndCertificate(@RequestParam long UserId, @RequestParam String type) {
        return onlineApplicationService.FindByIdAndCertificateType(UserId, type);
    }

    @GetMapping("/statuslist")
    public List<OnlineApplicationDto> getByStatus(@RequestParam String status) {
        return onlineApplicationService.getByStatus(status);
    }

    @PostMapping("/uploadfile/file")
    public void uploadFile(@RequestParam("file") MultipartFile multipartFile,@RequestParam("applicationId") String applicationId) {

        onlineApplicationService.upload(multipartFile,Long.valueOf(applicationId));

    }

    @GetMapping("/downloadfile/{applicationId}")
    public OnlineApplication downloadFile(@PathVariable Long applicationId){
        return onlineApplicationService.downloadFile(applicationId);
    }


}
