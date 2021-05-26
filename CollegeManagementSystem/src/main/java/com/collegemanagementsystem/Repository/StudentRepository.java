package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.profileEntity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("select r from Student r where r.userId= :id")
    Student getById(@Param("id")long id);

    @Query("select r from Student r where r.semester= :sem")
    List<Student> getRegistrationNo(@Param("sem")String sem);
}
