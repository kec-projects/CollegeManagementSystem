package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.StudentTopicEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentTopicRepository extends CrudRepository<StudentTopicEntity, Integer> {

    @Query(value = "select topic from StudentTopicEntity topic where topic.userId = :uid")
    //@Query("select new com.collegemanagementsystem.Entity.TopicEntity(r.topic) from TopicEntity r where r.UserID= :uid")
    List<StudentTopicEntity> findByUid(@Param("uid") Long uid);
    @Query("select r from StudentTopicEntity r where r.userId = :id AND r.topic= :nm")
    StudentTopicEntity checkTopic(@Param("id") Long id, @Param("nm") String nm);
    @Query("select r from StudentTopicEntity r ")
    List<StudentTopicEntity> allTopics();


}
