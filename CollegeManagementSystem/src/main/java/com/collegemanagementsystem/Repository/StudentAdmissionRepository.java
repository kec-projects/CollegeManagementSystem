package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.StudentAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAdmissionRepository extends JpaRepository<StudentAdmission,Integer> {
    @Query("select r from StudentAdmission r where r.name = :sm AND r.email= :em")
    StudentAdmission getStudent(@Param("sm")String sm, @Param("em") String em);
}
