package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.collegeDetailsEntity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{
    @Query("select r from Department r where r.id = :id")
    Department getDepartment(@Param("id")Long id);
}
