package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.FeeDivision;
import com.collegemanagementsystem.Entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeDivisionRepository extends JpaRepository<FeeDivision,Long> {
    @Query("select r from FeeDivision r where r.transactionId= :tid")
    List<FeeDivision> getByTransactionId(@Param("tid")String tid);
}
