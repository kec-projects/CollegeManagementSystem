package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.TopicEntity;
import com.collegemanagementsystem.Entity.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<TopicEntity, Integer> {

    @Query(value = "select topic from TopicEntity topic where topic.userId = :uid")
    //@Query("select new com.collegemanagementsystem.Entity.TopicEntity(r.topic) from TopicEntity r where r.UserID= :uid")
    List<TopicEntity> findByUid(@Param("uid") Long uid);
    @Query("select r from TopicEntity r where r.userId = :id AND r.topic= :nm")
    TopicEntity checkTopic(@Param("id") Long id, @Param("nm") String nm);


}
