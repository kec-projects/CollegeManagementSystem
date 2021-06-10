package com.collegemanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PushNotificationRequest {


	private String title;
    private String message;
    private String topic;
    private String token;
    private String registrationNo;

}