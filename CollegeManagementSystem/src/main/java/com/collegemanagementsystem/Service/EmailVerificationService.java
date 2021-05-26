package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Entity.User;
import com.collegemanagementsystem.Entity.ConfirmationToken;
import com.collegemanagementsystem.Repository.ConfirmationTokenRepository;
import com.collegemanagementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailVerificationService {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Map sendVerificationLink(String email,String password) throws MessagingException, UnsupportedEncodingException {
        User foundUser = userRepository.findByEmail(email);
        Map<String, String> msg = new HashMap();
        if (foundUser != null) {
            BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(25);
            ConfirmationToken confirmationToken = new ConfirmationToken();
            String token=DEFAULT_TOKEN_GENERATOR.generateKey().toString();
            confirmationToken.setConfirmationToken(token);
            confirmationToken.setUserEmail(foundUser.getEmail());
            Long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            confirmationToken.setCreatedDate(date);
            confirmationTokenRepository.save(confirmationToken);
            String subject = "Please verify your email";
            String content = "Dear [[name]],<br>"
                    + "Please click the link below to verify your registration:<br>"
                    + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                    + "Thank you,<br>"
                    + "Katihar Engineering College";
            content = content.replace("[[name]]", foundUser.getName());
            String verifyURL = "http://localhost:8080/email/verifyToken?token="+ URLEncoder.encode(token, "UTF-8")+"&email="+email+"&password="+password;
            content = content.replace("[[URL]]", verifyURL);
            sendEmailService.sendEmail(email,subject,content);
            msg.put("status", "Successful");
            msg.put("message", "Verification Link Sent");
        } else {
            msg.put("status", "Failed");
            msg.put("message", "User Not Found");
        }
        return msg;
    }
    public Map verifyToken(String email,String token,String password){
        Map msg =new HashMap();
        ConfirmationToken found= confirmationTokenRepository.findByConfirmationToken(token);
        if(found!=null){
            if(found.getUserEmail().equals(email)&&found.getConfirmationToken().equals(token) ){
                userRepository.updatePassword(passwordEncoder.encode(password),email);
                msg.put("status","Successful");
                msg.put("message","Password Changed");
            }
            else{
                msg.put("status","Failed");
                msg.put("message","Token Not Matched");
            }
            confirmationTokenRepository.delete(found);
        }
        else{
            msg.put("status","Failed");
            msg.put("message","Token Not Found");
        }
        return msg;
    }

}
