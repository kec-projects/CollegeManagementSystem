package com.collegemanagementsystem.Controller;
import com.collegemanagementsystem.Entity.PushNotificationRequest;
import com.collegemanagementsystem.Entity.PushNotificationResponse;
import com.collegemanagementsystem.Service.FCMService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class FCMController {

    private FCMService pushNotificationService;
    public FCMController(FCMService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }


    @PostMapping(value = "/notification/token")
    public  String sendTokenNotification( @RequestBody PushNotificationRequest request) throws ExecutionException, InterruptedException {
      return pushNotificationService.sendNotificationWithToken(request);
       // return "Notification has been sent.";//new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping(value = "/notification/topic")
    public  ResponseEntity sendTopicNotification(@RequestBody PushNotificationRequest request) throws ExecutionException, InterruptedException {
        pushNotificationService.sendMessageWithTopic(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
    @GetMapping("/subscribe/{uid}")
    public ResponseEntity subscribeToTopic(@PathVariable(value = "uid") long uid) throws ExecutionException, InterruptedException, FirebaseMessagingException {
        pushNotificationService.subscribeToTopics(uid);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Topic subscribed"), HttpStatus.OK);
    }
    @GetMapping("/subscribeToAll")
    public ResponseEntity subscribeToTopicForAll() throws ExecutionException, InterruptedException, FirebaseMessagingException {
        pushNotificationService.subscribeToTopicsForAll();
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Topic subscribed"), HttpStatus.OK);
    }
    @GetMapping("/unsubscribe/{uid}")
    public ResponseEntity unsubscribeToTopic(@PathVariable(value = "uid") Long uid) throws ExecutionException, InterruptedException, FirebaseMessagingException {
        pushNotificationService.unsubscribeToTopics(uid);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Topic unsubscribed"), HttpStatus.OK);
    }
    @GetMapping("/unsubscribeToAll")
    public ResponseEntity unsubscribeToTopicForAll() throws ExecutionException, InterruptedException, FirebaseMessagingException {
        pushNotificationService.unsubscribeToTopicsForAll();
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Topic unsubscribed"), HttpStatus.OK);
    }
}
