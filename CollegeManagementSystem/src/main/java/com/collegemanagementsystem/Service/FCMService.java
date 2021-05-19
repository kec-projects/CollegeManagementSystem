package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Entity.*;
import com.collegemanagementsystem.Repository.TokenRegistrationRepository;
import com.collegemanagementsystem.Repository.TopicRepository;
import com.google.firebase.messaging.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


@Service
public class FCMService {
        @Autowired
        private TokenRegistrationRepository tokenRepo;
        @Autowired
        private TopicRepository topicRepo;
        @Autowired
        ModelMapper mapper;
    Logger logger= LoggerFactory.getLogger(FCMInitializer.class);

    public void sendNotificationWithToken(PushNotificationRequest request) throws ExecutionException, InterruptedException {
        Message message = getPreconfiguredMessageBuilder(request).setToken(request.getToken())
                .build();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(message);
            String response= sendAndGetResponse(message);
            logger.info("Sent message to token. Device token: " + request.getToken() + ", " + response+ " msg "+jsonOutput);

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
        List<TopicEntity> topics=  topicRepo.findByUid(uid);
        List<String> topic=new ArrayList<>();
        for (TopicEntity newTopic: topics){
            topic.add(newTopic.getTopic());
        }

        for(String item: topic){
            TopicManagementResponse response = FirebaseMessaging.getInstance().subscribeToTopic(
                    token, item);
        }
        return " tokens were subscribed successfully";
    }

    public String unsubscribeToTopics(Long uid) throws FirebaseMessagingException {
        List<TokenRegistration> tokens= (List<TokenRegistration>) tokenRepo.getById(uid);
        List<String> token=new ArrayList<>();
        for (TokenRegistration newToken: tokens){
            token.add(newToken.getToken());
        }
      
        List<TopicEntity> topics= (List<TopicEntity>) topicRepo.findByUid(uid);
        List<String> topic=new ArrayList<>();
        for (TopicEntity newTopic: topics){
            topic.add(newTopic.getTopic());
        }
        for(String item: topic){
            TopicManagementResponse response = FirebaseMessaging.getInstance().unsubscribeFromTopic(
                    token,item);

        }
        return " tokens were unsubscribed successfully";
    }
}
