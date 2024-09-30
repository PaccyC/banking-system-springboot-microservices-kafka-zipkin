package com.paccy.transaction.services;

import com.paccy.transaction.account.AccountClient;
import com.paccy.transaction.entities.Transaction;
import com.paccy.transaction.enums.Status;
import com.paccy.transaction.exceptions.InsufficientBalanceException;
import com.paccy.transaction.repository.TransactionRepository;
import com.paccy.transaction.utils.AccountResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;

    @Transactional
    public Transaction  transfer(Integer fromAccountId, Integer toAccountId, Double amount,String token) {
        AccountResponse fromAccount= accountClient.getAccountById(fromAccountId);
        AccountResponse toAccount= accountClient.getAccountById(toAccountId);

        if (fromAccount.balance().compareTo(amount) < 0 ){
            throw new InsufficientBalanceException("Insufficient balance, please try again");
        }
        Double newFromAccountBalance=fromAccount.balance() - amount;
        Double newToAccountBalance=toAccount.balance() + amount;

        accountClient.updateBalance(fromAccountId, newFromAccountBalance,token);
        accountClient.updateBalance(toAccountId, newToAccountBalance,token);

        Transaction transaction = new Transaction();
        transaction.setTransactionId(UUID.randomUUID().toString());  // Generate a unique transaction ID
        transaction.setFromAccount(fromAccountId);
        transaction.setToAccount(toAccountId);
        transaction.setAmount(amount);
        transaction.setStatus(Status.SUCCESS);
        return transactionRepository.save(transaction);




    }


}
