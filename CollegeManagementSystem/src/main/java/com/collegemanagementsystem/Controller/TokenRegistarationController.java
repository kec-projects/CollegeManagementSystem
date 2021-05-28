package com.collegemanagementsystem.Controller;
import com.collegemanagementsystem.Dto.TokenRegistrationDTO;
import com.collegemanagementsystem.Entity.TokenRegistration;
import com.collegemanagementsystem.Service.TokenRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fcm")
public class TokenRegistarationController {

    @Autowired
    private TokenRegistrationService service;

    @PostMapping(value = "/token")
    public String addToken(@RequestBody TokenRegistrationDTO dto) {
         service.addToken(dto);
         return "Token added";
    }
    @DeleteMapping("/token/{id}")
    public String deleteById(@RequestBody @PathVariable(value = "id")Long uid ){
         service.deleteById(uid);
         return "Token Deleted Successfully";
    }
    @GetMapping("/token/{registration}")
    public List<TokenRegistration> getToken(@PathVariable(value = "registration")String registration){
        return service.getToken(registration);
}
    @DeleteMapping("/token")
    public String deleteAllStudents(){
        return service.delete();

    }

}
