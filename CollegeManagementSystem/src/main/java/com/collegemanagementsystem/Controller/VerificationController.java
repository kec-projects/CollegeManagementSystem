package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Service.SendEmailService;
import com.collegemanagementsystem.Service.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/email")
public class VerificationController {
    @Autowired
    private SendEmailService emailOtpService;
    @Autowired
    private EmailVerificationService emailVerificationService;
    @RequestMapping(value = "/otp", method = RequestMethod.GET)
    @ResponseBody
    public void sendOtp() throws MessagingException, UnsupportedEncodingException {

        //emailOtpService.sendOtp();

    }
    @RequestMapping(value = "/verificationLink", method = RequestMethod.GET)
    @ResponseBody
    public Map sendVerificationLink(@RequestParam String email ,@RequestParam String password) throws MessagingException, UnsupportedEncodingException {
      return  emailVerificationService.sendVerificationLink(email,password);
    }
    @RequestMapping(value="/passwordReset",method = RequestMethod.GET)
    @ResponseBody
    public Map passwordReset(@RequestParam String email ,@RequestParam String password){
        System.out.println("Password Changed");
        return null;
    }
    @RequestMapping(value="/verifyToken",method = RequestMethod.GET)
    @ResponseBody
    public Map verifyToken(@RequestParam String token,@RequestParam String email,@RequestParam String password) throws UnsupportedEncodingException {

       return emailVerificationService.verifyToken(email,URLDecoder.decode(token, "UTF-8"),password);
        //System.out.println(email);
    }
}
