package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.ProfileImageEntity;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImageEntity,Long> {
    @Query("select r from ProfileImageEntity r where r.userId= :id")
    ProfileImageEntity getById(@Param("id") long id);

}
