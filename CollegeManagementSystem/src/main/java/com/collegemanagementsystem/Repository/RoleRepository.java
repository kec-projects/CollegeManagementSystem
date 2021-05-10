package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query("select r from Role r where r.name = :sm")
    Role getRoleByName(@Param("sm") String sm);
}