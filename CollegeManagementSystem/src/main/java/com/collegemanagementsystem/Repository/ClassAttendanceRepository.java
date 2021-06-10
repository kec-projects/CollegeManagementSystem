package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.AttendanceEntity.ClassAttendanceEntity;
import com.collegemanagementsystem.Entity.StudentAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassAttendanceRepository extends JpaRepository<ClassAttendanceEntity,Long> {

    @Query("select r from ClassAttendanceEntity r where r.classId = :sm")
    List getClassAttendanceCount(@Param("sm")Long sm);
}
