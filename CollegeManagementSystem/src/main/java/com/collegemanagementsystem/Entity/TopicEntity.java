package com.collegemanagementsystem.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Topic")
@IdClass(TopicUid.class)
public class TopicEntity implements Serializable {
    @Id
    private String topic;
    @Id
    private long userId;

}
