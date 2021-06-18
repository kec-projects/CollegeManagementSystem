package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.OnlineApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OnlineApplicationRepository extends CrudRepository<OnlineApplication, Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update OnlineApplication r set r.status=:news where r.status=:olds")
    void updateStatus(@Param("olds")String olds, @Param("news")String news);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update OnlineApplication r set r.approvedDate =:date ")
    String updateApprovedDate(@Param("date") Date date);

    @Query("select r from OnlineApplication r where r.userId =:uid and r.certificateType=:ty ")
    OnlineApplication findByIdAndCertificate(@Param("uid")long userId,@Param("ty") String type);
    @Query("select r from OnlineApplication r where r.userId =:uid  ")
    List<OnlineApplication> getById(@Param("uid")long userId);
}
