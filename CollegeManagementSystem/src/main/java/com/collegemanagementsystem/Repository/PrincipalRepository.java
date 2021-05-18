package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.StudentAdmission;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.PrincipalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrincipalRepository extends JpaRepository<PrincipalDetails,Integer>{
    @Query("select r from PrincipalDetails r where r.id= :id")
    PrincipalDetails getPrincipal( @Param("id") String id);
}
