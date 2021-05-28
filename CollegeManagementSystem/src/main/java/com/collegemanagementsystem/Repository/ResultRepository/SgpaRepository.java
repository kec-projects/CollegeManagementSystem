package com.collegemanagementsystem.Repository.ResultRepository;

import com.collegemanagementsystem.Entity.ResultEntity.SgpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SgpaRepository extends JpaRepository<SgpaEntity,Long> {

    @Query("select r.sgpa from SgpaEntity r where r.reg=:reg AND r.sem=:sem")
    String getSgpa(@Param("reg")String reg,@Param("sem") String sem);
}
