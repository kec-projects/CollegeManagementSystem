package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.AttendanceEntity.StudentAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAttendanceRepository extends JpaRepository<StudentAttendanceEntity,Long> {

    @Query("select r from StudentAttendanceEntity r where r.classId = :cid AND r.userId=:uid")
    List getStudentAttendance(@Param("cid")Long cid, @Param("uid")Long uid);
}
