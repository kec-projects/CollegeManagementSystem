package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.User;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.CollegeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<CollegeDetails,Long>{
    @Query("select r from CollegeDetails r where r.id = :id ")
    CollegeDetails findCollege(@Param("id")Long id);

}
