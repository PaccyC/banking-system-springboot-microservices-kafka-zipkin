package com.paccy.customer_account.repository;

import com.paccy.customer_account.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findByCustomerId(Integer customerId);
}
