package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.TopicDto;
import com.collegemanagementsystem.Entity.TopicUid;
import com.collegemanagementsystem.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/fcm")
public class TopicController {
  @Autowired
  public TopicService service;

    @GetMapping(value = "/addtopic/{uid}")
    public Map addTopic(@PathVariable(value = "uid")Long uid) {
      return service.addTopic(uid);
       //return "Topic Added";
    }
    @GetMapping(value = "/addTopicToAll")
    public String addTopicToAll() {
        service.addAllStudentTopics();
        return "Topic Added";
    }
    @DeleteMapping ("/topic/{uid}")
    public String FindById(@PathVariable(value = "uid")Long uid ){
         service.DeleteByUid(uid);
        return "Topic Deleted Successfully";
    }
    @DeleteMapping ("/delete/AllTopic")
    public String FindById( ){
        service.DeleteAllStudentTopics();
        return "Topic Deleted Successfully";
    }
    @GetMapping(value = "/alltopics")
    public Set alltopics() {
       return service.alltopics();

    }
}
