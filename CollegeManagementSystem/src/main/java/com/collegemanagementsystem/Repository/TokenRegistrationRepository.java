package com.collegemanagementsystem.Repository;
import com.collegemanagementsystem.Entity.TokenRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TokenRegistrationRepository extends CrudRepository<TokenRegistration, Integer> {


}