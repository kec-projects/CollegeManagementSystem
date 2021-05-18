package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.profileEntity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
