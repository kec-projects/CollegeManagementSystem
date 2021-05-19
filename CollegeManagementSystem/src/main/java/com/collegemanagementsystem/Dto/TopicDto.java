package com.collegemanagementsystem.Dto;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class TopicDto  {

    private String topic;
    private long userId;

}
