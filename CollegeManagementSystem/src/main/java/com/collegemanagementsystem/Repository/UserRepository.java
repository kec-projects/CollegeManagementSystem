package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);

    @Query("select r from User r where r.email = :email ")
    User findById(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("update User r set r.password=:password where r.email=:email")
    void updatePassword(@Param("password") String password,@Param("email") String email);
}
