package com.paccy.banking_system.transaction.repository;

import com.paccy.banking_system.transaction.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
