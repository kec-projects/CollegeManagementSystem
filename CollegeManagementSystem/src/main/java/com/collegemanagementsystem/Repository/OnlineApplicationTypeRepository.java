package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.OnlineApplicationType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OnlineApplicationTypeRepository extends CrudRepository<OnlineApplicationType, Long> {

    @Query("select r from OnlineApplicationType r where r.applicationTypeName =:name  ")
    List<OnlineApplicationType> getById(@Param("name") String applicationTypeName);

    @Transactional
    @Modifying
    @Query("delete from OnlineApplicationType r where r.applicationTypeName =:name  ")
    void deleteById(@Param("name") String name);
}
