package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);

    @Query("select r from User r where r.email = :email ")
    User findById(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("update User r set r.password=:password where r.email=:email")
    void updatePassword(@Param("password") String password,@Param("email") String email);

    @Query("select r from User r where r.accountStatus = :status ")
    List< User> getUser(@Param("status") String status);

    @Modifying
    @Transactional
    @Query("update User r set r.updatedDate=:date where r.userId=:id")
    void updateDate(@Param("date")Date date,@Param("id")Long id);


}
