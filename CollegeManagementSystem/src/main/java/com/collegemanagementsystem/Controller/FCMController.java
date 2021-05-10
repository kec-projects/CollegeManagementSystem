package com.collegemanagementsystem.Controller;
import com.collegemanagementsystem.Entity.PushNotificationRequest;
import com.collegemanagementsystem.Entity.PushNotificationResponse;
import com.collegemanagementsystem.Service.FCMService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class FCMController {

    private FCMService pushNotificationService;
    public FCMController(FCMService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }


    @PostMapping(value = "/notification/token")
    public  ResponseEntity sendTokenNotification( @RequestBody PushNotificationRequest request) throws ExecutionException, InterruptedException {
        pushNotificationService.sendNotificationWithToken(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping(value = "/notification/topic")
    public  ResponseEntity sendNotification(@RequestBody PushNotificationRequest request) throws ExecutionException, InterruptedException {
        pushNotificationService.sendMessageWithTopic(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
}
