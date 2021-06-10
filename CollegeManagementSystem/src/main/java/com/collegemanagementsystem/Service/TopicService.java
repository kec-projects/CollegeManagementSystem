package com.collegemanagementsystem.Service;


import com.collegemanagementsystem.Entity.*;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import com.collegemanagementsystem.Repository.StudentRepository;
import com.collegemanagementsystem.Repository.TopicRepository;
import com.collegemanagementsystem.Repository.UserRepository;
import com.collegemanagementsystem.Repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicrepo;

    @Autowired
    ModelMapper mapper;
    @Autowired
    public UserRepository userrepo;
    @Autowired
    public UserRoleRepository userrolerepo;
    @Autowired
    private StudentRepository studentrepo;

    public void addTopic(Long uid){
        List<UserRole> roles=userrolerepo.getRoleById(uid);
        Student students=studentrepo.getById(uid);
        List<String> role=new ArrayList<>();
        for (UserRole newRole: roles){
            role.add(newRole.getRoleName());
        }

        for (String newRole: role){
            if(newRole.toLowerCase().equals("student")){
                List<TopicEntity> topics = new ArrayList<>();
                TopicEntity topic=new TopicEntity();
                topic.setUserId(uid);
                topic.setTopic(students.getDepartment());
                TopicEntity department= mapper.map(topic,TopicEntity.class);
                topics.add(department);
                topic=new TopicEntity();
                topic.setUserId(uid);
                topic.setTopic(newRole);
                TopicEntity role1= mapper.map(topic,TopicEntity.class);
                topics.add(role1);
                topic=new TopicEntity();
                topic.setUserId(uid);
                topic.setTopic(students.getSemester());
                TopicEntity semester= mapper.map(topic,TopicEntity.class);
                topics.add(semester);
                topic=new TopicEntity();
                topic.setUserId(uid);
                topic.setTopic(students.getSemester_department());
                TopicEntity sem_dep= mapper.map(topic,TopicEntity.class);
                topics.add(sem_dep);
                topic=new TopicEntity();
                topic.setUserId(uid);
                topic.setTopic("general");
                topic= mapper.map(topic,TopicEntity.class);
                topics.add(topic);
                topicrepo.saveAll(topics);
            }
            if(newRole.toLowerCase().equals("faculty")){
                List<TopicEntity> topics = new ArrayList<>();
                TopicEntity topic=new TopicEntity();
                topic.setUserId(uid);
                topic.setTopic(students.getDepartment());
                TopicEntity department= mapper.map(topic,TopicEntity.class);
                topics.add(department);
                topic=new TopicEntity();
                topic.setUserId(uid);
                topic.setTopic(newRole);
                topic= mapper.map(topic,TopicEntity.class);
                topics.add(topic);
                topic =new TopicEntity();
                topic.setUserId(uid);
                topic.setTopic("general");
                topics.add(topic);
                topicrepo.saveAll(topics);
            }
        }

    }
    public String DeleteByUid(Long uid){
        topicrepo.deleteById(Math.toIntExact(uid));
        return "Deleted";
    }
    public Set alltopics(){
       List<TopicEntity> topics=  topicrepo.allTopics();
        Set<Map> topicName=new HashSet<>();
     for (TopicEntity topic: topics){
        Map<String, String> msg = new HashMap();
        msg.put("name",topic.getTopic());
         topicName.add(msg);
    }
        return topicName;}

}
