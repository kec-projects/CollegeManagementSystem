package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.SubjectTeacherEntity;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacherEntity,Long> {

    @Query("select r from SubjectTeacherEntity r where r.userId= :userId AND r.flag=:flag")
    List<SubjectTeacherEntity> getSubject(@Param("userId") Long userId,@Param("flag") String flag);
}
