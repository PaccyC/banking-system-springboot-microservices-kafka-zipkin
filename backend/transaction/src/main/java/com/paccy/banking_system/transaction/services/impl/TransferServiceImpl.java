package com.paccy.banking_system.transaction.services.impl;

import com.paccy.banking_system.transaction.account.AccountClient;
import com.paccy.banking_system.transaction.entities.Transaction;
import com.paccy.banking_system.transaction.entities.domain.ApiResponse;
import com.paccy.banking_system.transaction.enums.Status;
import com.paccy.banking_system.transaction.exceptions.InsufficientBalanceException;
import com.paccy.banking_system.transaction.kafka.TransactionProducer;
import com.paccy.banking_system.transaction.repository.TransactionRepository;
import com.paccy.banking_system.transaction.services.TransferService;
import com.paccy.banking_system.transaction.utils.AccountResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;
    private final TransactionProducer transactionProducer;


    /**
     * It transfers the balance between two account
     * Parameters are accountID of the sending account, accountID of the receiving account , amount to be transferred and token to make sure that user is authenticated and authorised
     */
    @Transactional
    public Transaction transfer(Integer fromAccountId, Integer toAccountId, Double amount, String token) {
        ApiResponse<AccountResponse> fromAccount = accountClient.getAccountById(fromAccountId);
        ApiResponse<AccountResponse> toAccount = accountClient.getAccountById(toAccountId);

        if (fromAccount.getData().balance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance, please try again");
        }
        Double newFromAccountBalance = fromAccount.getData().balance() - amount;
        Double newToAccountBalance = toAccount.getData().balance() + amount;

        accountClient.updateBalance(fromAccountId, newFromAccountBalance, token);
        accountClient.updateBalance(toAccountId, newToAccountBalance, token);

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
