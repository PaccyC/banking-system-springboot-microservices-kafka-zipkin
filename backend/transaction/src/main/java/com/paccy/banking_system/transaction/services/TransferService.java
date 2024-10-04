package com.paccy.banking_system.transaction.services;

import com.paccy.banking_system.transaction.account.AccountClient;
import com.paccy.banking_system.transaction.entities.Transaction;
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
@RequiredArgsConstructor
public class TransferService {
    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;
    private  final TransactionProducer transactionProducer;

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
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setFromAccount(fromAccountId);
        transaction.setToAccount(toAccountId);
        transaction.setAmount(amount);
        transaction.setStatus(Status.SUCCESS);



        transactionProducer.sendTransactionConfirmation();

        return transactionRepository.save(transaction);




    }


}
