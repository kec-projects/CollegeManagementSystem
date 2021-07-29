package com.collegemanagementsystem.Repository;
import com.collegemanagementsystem.Entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,String> {
    @Query("select r from TransactionHistory r where r.userId= :id")
    List<TransactionHistory> getById(@Param("id")long id);

    @Query("select r from TransactionHistory r where r.transactionId= :tid")
    TransactionHistory getByTransactionId(@Param("tid")String tid);

    @Query("select r from TransactionHistory r where r.paymentDoneFor= :eml")
    List<TransactionHistory> getByEmail(@Param("eml") String eml);

    @Query("from TransactionHistory  where date between :srtD and :endD")
    List<TransactionHistory> getByDate(@Param("srtD") Date srtD, @Param("endD")Date endD);
}
