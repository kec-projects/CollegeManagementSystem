package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.FeeDivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeDivisionRepository extends JpaRepository<FeeDivision,Long> {
}
