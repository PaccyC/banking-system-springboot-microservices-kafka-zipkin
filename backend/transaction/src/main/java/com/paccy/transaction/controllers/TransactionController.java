package com.paccy.transaction.controllers;

import com.paccy.transaction.entities.Transaction;
import com.paccy.transaction.repository.TransactionRepository;
import com.paccy.transaction.services.TransactionService;
import com.paccy.transaction.services.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionRepository transactionRepository;

    private final TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> sendMoney(
            @RequestParam() Integer fromAccountId,
            @RequestParam() Integer toAccountId,
            @RequestParam double amount,
            @RequestHeader("Authorization") String token


    ){
        Transaction transaction = transferService.transfer(fromAccountId, toAccountId, amount,token);
        return  ResponseEntity.ok(transaction);
    }


}
