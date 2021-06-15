package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail,Long>{

    @Transactional
    @Modifying
    @Query("delete from PaymentDetail r where r.paymentType=:payt")
     void deleteByPaymentType(@Param("payt") String payt);

    @Transactional
    @Modifying
    @Query("delete from PaymentDetail r where r.paymentName=:paynm and r.paymentType=:payt")
     void deleteByPaymentNameAndPaymentType(@Param("paynm") String paynm,@Param("payt") String payt);

    @Query("select r from PaymentDetail r where r.paymentType=:payt")
    List<PaymentDetail> getPaymentDetailByPaymentType(@Param("payt")String payt);

    @Query("select r from PaymentDetail r where r.paymentType=:payt and r.category=:cat")
    List<PaymentDetail> getPaymentDetailByCategory(@Param("payt")String payt, @Param("cat") String cat);

    @Modifying(clearAutomatically = true)
    @javax.transaction.Transactional
    @Query("update PaymentDetail r set r.paymentType =:newpayt where r.paymentType=:oldpayt")
    void updatePaymentType(@Param("newpayt") String newpayt,@Param("oldpayt") String oldpayt);

    @Modifying(clearAutomatically = true)
    @javax.transaction.Transactional
    @Query("update PaymentDetail r set r.paymentName=:paynm where r.paymentType=:payt")
    void updatePaymentName(@Param("payt") String payt, @Param("paynm") String paynm);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update PaymentDetail r set r.amount=:amt where r.paymentType=:payt and r.paymentName=:paynm")
    void updateAmount(@Param("payt") String payt, @Param("paynm") String paynm,@Param("amt") Double amt);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update PaymentDetail r set r.category=:cat where r.paymentType=:payt and r.paymentName=:paynm")
    void updateCategory(@Param("payt") String payt, @Param("paynm") String paynm,@Param("cat") String cat);
}

