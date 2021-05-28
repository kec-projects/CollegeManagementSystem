package com.collegemanagementsystem.Repository.ResultRepository;

import com.collegemanagementsystem.Entity.ResultEntity.TheoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheoryRepository extends JpaRepository<TheoryEntity,Long> {
}
