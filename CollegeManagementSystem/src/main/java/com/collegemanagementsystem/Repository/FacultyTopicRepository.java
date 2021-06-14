package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.FacultyTopicEntity;
import com.collegemanagementsystem.Entity.StudentTopicEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyTopicRepository extends CrudRepository<FacultyTopicEntity, Integer> {


    @Query(value = "select topic from FacultyTopicEntity topic where topic.userId = :uid")
        //@Query("select new com.collegemanagementsystem.Entity.TopicEntity(r.topic) from TopicEntity r where r.UserID= :uid")
    List<FacultyTopicEntity> findByUid(@Param("uid") Long uid);
    @Query("select r from FacultyTopicEntity r where r.userId = :id AND r.topic= :nm")
    FacultyTopicEntity checkTopic(@Param("id") Long id, @Param("nm") String nm);
    @Query("select r from FacultyTopicEntity r ")
    List<FacultyTopicEntity> allTopics();
}