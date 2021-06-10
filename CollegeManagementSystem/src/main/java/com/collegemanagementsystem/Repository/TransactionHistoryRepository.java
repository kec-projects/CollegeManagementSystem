package com.collegemanagementsystem.Repository;

import com.collegemanagementsystem.Entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Long> {
}
