package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.profileEntity.Faculty;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long> {
    @Query("select r from Faculty r where r.employmentId= :empId")
    Faculty getRegistrationNo(@Param("empId")String empId);
}
