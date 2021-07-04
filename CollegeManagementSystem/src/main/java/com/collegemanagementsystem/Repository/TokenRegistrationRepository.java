package com.collegemanagementsystem.Repository;
import com.collegemanagementsystem.Entity.TokenRegistration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TokenRegistrationRepository extends CrudRepository<TokenRegistration, Integer> {
    @Query("select r from TokenRegistration r where r.userId= :id")
    List<TokenRegistration> getById(@Param("id")Long id);

}