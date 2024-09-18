package com.paccy.transaction.services;

import com.paccy.transaction.account.AccountClient;
import com.paccy.transaction.exceptions.InsufficientBalanceException;
import com.paccy.transaction.repository.TransactionRepository;
import com.paccy.transaction.utils.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;

    public void  transfer(Integer fromAccountId, Integer toAccountId, double amount) {
        AccountResponse fromAccount= accountClient.getAccountById(fromAccountId);
        AccountResponse toAccount= accountClient.getAccountById(toAccountId);

        if (fromAccount.balance().compareTo(amount) < 0 ){
            throw new InsufficientBalanceException("Insufficient balance, please try again");
        }

    }
}
