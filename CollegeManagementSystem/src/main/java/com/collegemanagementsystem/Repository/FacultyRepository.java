package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.profileEntity.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long> {
}
