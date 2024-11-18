package com.paccy.banking_system.transaction.services;

import com.paccy.banking_system.transaction.account.AccountClient;
import com.paccy.banking_system.transaction.entities.Transaction;
import com.paccy.banking_system.transaction.entities.domain.ApiResponse;
import com.paccy.banking_system.transaction.enums.Status;
import com.paccy.banking_system.transaction.exceptions.InsufficientBalanceException;
import com.paccy.banking_system.transaction.kafka.TransactionProducer;
import com.paccy.banking_system.transaction.kafka.TransactionSuccessMessage;
import com.paccy.banking_system.transaction.repository.TransactionRepository;
import com.paccy.banking_system.transaction.utils.AccountResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TransferService {

    @Transactional
    public Transaction  transfer(Integer fromAccountId, Integer toAccountId, Double amount,String token);

}
