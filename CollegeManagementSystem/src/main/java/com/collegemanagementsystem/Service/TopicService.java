package com.collegemanagementsystem.Service;


import com.collegemanagementsystem.Entity.*;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import com.collegemanagementsystem.Repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {
    @Autowired
    private StudentTopicRepository studentTopicRepo;

    @Autowired
    ModelMapper mapper;
    @Autowired
    public UserRepository userrepo;
    @Autowired
    public UserRoleRepository userrolerepo;
    @Autowired
    private StudentRepository studentrepo;
    @Autowired
    private FacultyTopicRepository facultyTopicRepo;

    public void addTopic(Long uid){
        List<UserRole> roles=userrolerepo.getRoleById(uid);
        Student students=studentrepo.getById(uid);
        List<String> role=new ArrayList<>();
        for (UserRole newRole: roles){
            role.add(newRole.getRoleName());
        }

        for (String newRole: role){
            if(newRole.toLowerCase().equals("student")){
                List<StudentTopicEntity> topics = new ArrayList<>();
                StudentTopicEntity topic=new StudentTopicEntity();
                topic.setUserId(uid);
                topic.setTopic(students.getDepartment());
                StudentTopicEntity department= mapper.map(topic, StudentTopicEntity.class);
                topics.add(department);
                topic=new StudentTopicEntity();
                topic.setUserId(uid);
                topic.setTopic(newRole);
                StudentTopicEntity role1= mapper.map(topic, StudentTopicEntity.class);
                topics.add(role1);
                topic=new StudentTopicEntity();
                topic.setUserId(uid);
                topic.setTopic(students.getSemester());
                StudentTopicEntity semester= mapper.map(topic, StudentTopicEntity.class);
                topics.add(semester);
                topic=new StudentTopicEntity();
                topic.setUserId(uid);
                topic.setTopic(students.getSemester_department());
                StudentTopicEntity sem_dep= mapper.map(topic, StudentTopicEntity.class);
                topics.add(sem_dep);
                topic=new StudentTopicEntity();
                topic.setUserId(uid);
                topic.setTopic("general");
                topic= mapper.map(topic, StudentTopicEntity.class);
                topics.add(topic);
                studentTopicRepo.saveAll(topics);
            }
            if(newRole.toLowerCase().equals("faculty")){
                List<FacultyTopicEntity> topics = new ArrayList<>();
                FacultyTopicEntity topic=new FacultyTopicEntity();
                topic.setUserId(uid);
                topic.setTopic(students.getDepartment());
                FacultyTopicEntity department= mapper.map(topic, FacultyTopicEntity.class);
                topics.add(department);
                topic=new FacultyTopicEntity();
                topic.setUserId(uid);
                topic.setTopic(newRole);
                topic= mapper.map(topic, FacultyTopicEntity.class);
                topics.add(topic);
                topic =new FacultyTopicEntity();
                topic.setUserId(uid);
                topic.setTopic("general");
                topics.add(topic);
                facultyTopicRepo.saveAll(topics);
            }
        }

    }
    public void addAllStudentTopics(){

        List<Student> listStudents= (List<Student>) studentrepo.findAll();
        for (Student students: listStudents){
            List<UserRole> roles=userrolerepo.getRoleById(students.getUserId());
            List<String> role=new ArrayList<>();
            for (UserRole newRole: roles){
                role.add(newRole.getRoleName());
            }
        for (String newRole: role){
            if(newRole.toLowerCase().equals("student")){
                List<StudentTopicEntity> topics = new ArrayList<>();
                StudentTopicEntity topic=new StudentTopicEntity();
                topic.setUserId(students.getUserId());
                topic.setTopic(students.getDepartment());
                StudentTopicEntity department= mapper.map(topic, StudentTopicEntity.class);
                topics.add(department);
                topic=new StudentTopicEntity();
                topic.setUserId(students.getUserId());
                topic.setTopic(newRole);
                StudentTopicEntity role1= mapper.map(topic, StudentTopicEntity.class);
                topics.add(role1);
                topic=new StudentTopicEntity();
                topic.setUserId(students.getUserId());
                topic.setTopic(students.getSemester());
                StudentTopicEntity semester= mapper.map(topic, StudentTopicEntity.class);
                topics.add(semester);
                topic=new StudentTopicEntity();
                topic.setUserId(students.getUserId());
                topic.setTopic(students.getSemester_department());
                StudentTopicEntity sem_dep= mapper.map(topic, StudentTopicEntity.class);
                topics.add(sem_dep);
                topic=new StudentTopicEntity();
                topic.setUserId(students.getUserId());
                topic.setTopic("general");
                topic= mapper.map(topic, StudentTopicEntity.class);
                topics.add(topic);
                studentTopicRepo.saveAll(topics);
            }

        }}

    }
    public String DeleteByUid(Long uid){
        studentTopicRepo.deleteById(Math.toIntExact(uid));
        facultyTopicRepo.deleteById(Math.toIntExact(uid));
        return "Deleted";
    }

    public String DeleteAllStudentTopics(){
        studentTopicRepo.deleteAll();
        return "Deleted";
    }

    public Set alltopics(){
       List<StudentTopicEntity> studentTopics=  studentTopicRepo.allTopics();
        List<FacultyTopicEntity> facultyTopics=  facultyTopicRepo.allTopics();

        Set<Map> topicName=new HashSet<>();
     for (StudentTopicEntity topic: studentTopics){
        Map<String, String> msg = new HashMap();
        msg.put("name",topic.getTopic());
         topicName.add(msg);
    }
        for (FacultyTopicEntity topic: facultyTopics){
            Map<String, String> msg = new HashMap();
            msg.put("name",topic.getTopic());
            topicName.add(msg);
        }
        return topicName;}

}
