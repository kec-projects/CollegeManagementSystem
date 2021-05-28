package com.collegemanagementsystem.Repository.ResultRepository;

import com.collegemanagementsystem.Entity.ResultEntity.PracticalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticalRepository extends JpaRepository<PracticalEntity,Long> {
}
