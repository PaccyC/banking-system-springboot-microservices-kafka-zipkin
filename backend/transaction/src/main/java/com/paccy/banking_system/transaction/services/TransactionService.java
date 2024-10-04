package com.paccy.banking_system.transaction.services;

import com.paccy.banking_system.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private  final  TransferService transferService;




}
