package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.TokenRegistrationDTO;
import com.collegemanagementsystem.Entity.PushNotificationRequest;
import com.collegemanagementsystem.Entity.TokenRegistration;
import com.collegemanagementsystem.Entity.StudentTopicEntity;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import com.collegemanagementsystem.Repository.FacultyTopicRepository;
import com.collegemanagementsystem.Repository.StudentRepository;
import com.collegemanagementsystem.Repository.TokenRegistrationRepository;
import com.collegemanagementsystem.Repository.StudentTopicRepository;
import com.google.firebase.messaging.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class FCMService {
        @Autowired
        private TokenRegistrationRepository tokenRepo;
        @Autowired
        private StudentTopicRepository studentTopicRepo;
    @Autowired
    private FacultyTopicRepository facultyTopicRepo;

    @Autowired
    private StudentRepository student;
        @Autowired
        ModelMapper mapper;
    @Autowired
    public TokenRegistrationService tokenservice;
    Logger logger= LoggerFactory.getLogger(FCMInitializer.class);

    public String sendNotificationWithToken(PushNotificationRequest request) throws ExecutionException, InterruptedException {
       List<TokenRegistrationDTO> tokens= tokenservice.getToken(request.getRegistrationNo());
       if (tokens==null){
           return "Token not found";
       }
       System.out.println(tokens.isEmpty());
        for (TokenRegistrationDTO token: tokens) {
            Message message = getPreconfiguredMessageBuilder(request).setToken(token.getToken())
                    .build();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(message);
            String response = sendAndGetResponse(message);
            System.out.println(token.getToken());
            logger.info("Sent message to token. Device token: " + request.getToken() + ", " + response + " msg " + jsonOutput);
        }
        return "Notification has been sent.";
    }

    public void sendMessageWithTopic(PushNotificationRequest request)
            throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessage(request);
        String response = sendAndGetResponse(message);
        logger.info("Sent message without data. Topic: " + request.getTopic() + ", " + response);
    }

    private Message getPreconfiguredMessage(PushNotificationRequest request) {
        return getPreconfiguredMessageBuilder(request).setTopic(request.getTopic())
                .build();
    }
    private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
        return FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private Message.Builder getPreconfiguredMessageBuilder(PushNotificationRequest request) {
        AndroidConfig androidConfig = getAndroidConfig(request.getTopic());
        ApnsConfig apnsConfig = getApnsConfig(request.getTopic());
        return Message.builder()
                .setApnsConfig(apnsConfig).setAndroidConfig(androidConfig).setNotification(
                        new Notification(request.getTitle(), request.getMessage()));
    }

    private ApnsConfig getApnsConfig(String topic) {
        return ApnsConfig.builder()
                .setAps(Aps.builder().setCategory(topic).setThreadId(topic).build()).build();
    }

    private AndroidConfig getAndroidConfig(String topic) {
        return AndroidConfig.builder()
                .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(topic)
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder().setSound("default").setColor("#FFFF00").setTag(topic).build()).build();
    }


    public String subscribeToTopics(Long uid ) throws FirebaseMessagingException {
        List<TokenRegistration> tokens=  tokenRepo.getById(uid);
        List<String> token=new ArrayList<>();
        for (TokenRegistration newToken: tokens){
            token.add(newToken.getToken());
        }
        List<StudentTopicEntity> topics=  studentTopicRepo.findByUid(uid);
        List<String> topic=new ArrayList<>();
        for (StudentTopicEntity newTopic: topics){
            topic.add(newTopic.getTopic());
        }

        for(String item: topic){
            TopicManagementResponse response = FirebaseMessaging.getInstance().subscribeToTopic(
                    token, item);
        }
        return " tokens were subscribed successfully";
    }
    public String subscribeToTopicsForAll( ) throws FirebaseMessagingException {
        List<Student> listStudents= (List<Student>) student.findAll();
        for(Student student: listStudents){
        List<TokenRegistration> tokens=  tokenRepo.getById(student.getUserId());
        List<String> token=new ArrayList<>();
        for (TokenRegistration newToken: tokens){
            token.add(newToken.getToken());
        }
        List<StudentTopicEntity> topics=  studentTopicRepo.findByUid(student.getUserId());
        List<String> topic=new ArrayList<>();
        for (StudentTopicEntity newTopic: topics){
            topic.add(newTopic.getTopic());
        }

        for(String item: topic){
            TopicManagementResponse response = FirebaseMessaging.getInstance().subscribeToTopic(
                    token, item);
        }}
        return " tokens were subscribed successfully";
    }

    public String unsubscribeToTopics(Long uid) throws FirebaseMessagingException {
        List<TokenRegistration> tokens= (List<TokenRegistration>) tokenRepo.getById(uid);
        List<String> token=new ArrayList<>();
        for (TokenRegistration newToken: tokens){
            token.add(newToken.getToken());
        }
      
        List<StudentTopicEntity> topics= (List<StudentTopicEntity>) studentTopicRepo.findByUid(uid);
        List<String> topic=new ArrayList<>();
        for (StudentTopicEntity newTopic: topics){
            topic.add(newTopic.getTopic());
        }
        for(String item: topic){
            TopicManagementResponse response = FirebaseMessaging.getInstance().unsubscribeFromTopic(
                    token,item);

        }
        return " tokens were unsubscribed successfully";
    }
    public String unsubscribeToTopicsForAll( ) throws FirebaseMessagingException {
        List<Student> listStudents= (List<Student>) student.findAll();
        for(Student student: listStudents){
            List<TokenRegistration> tokens=  tokenRepo.getById(student.getUserId());
            List<String> token=new ArrayList<>();
            for (TokenRegistration newToken: tokens){
                token.add(newToken.getToken());
            }
            List<StudentTopicEntity> topics=  studentTopicRepo.findByUid(student.getUserId());
            List<String> topic=new ArrayList<>();
            for (StudentTopicEntity newTopic: topics){
                topic.add(newTopic.getTopic());
            }

            for(String item: topic){
                TopicManagementResponse response = FirebaseMessaging.getInstance().unsubscribeFromTopic(
                        token,item);
            }}
        return " tokens were unsubscribed successfully";
    }

}
