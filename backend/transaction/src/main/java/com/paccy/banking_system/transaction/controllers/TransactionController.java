package com.paccy.banking_system.transaction.controllers;

import com.paccy.banking_system.transaction.entities.Transaction;
import com.paccy.banking_system.transaction.entities.domain.ApiResponse;
import com.paccy.banking_system.transaction.repository.TransactionRepository;
import com.paccy.banking_system.transaction.services.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionRepository transactionRepository;

    private final TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<ApiResponse<Transaction>> sendMoney(
            @RequestParam() Integer fromAccountId,
            @RequestParam() Integer toAccountId,
            @RequestParam double amount,
            @RequestHeader("Authorization") String token


    ){
        Transaction transaction = transferService.transfer(fromAccountId, toAccountId, amount,token);
        return  new ApiResponse<>(transaction,"Money sent successfully", HttpStatus.CREATED).toResponseEntity();
    }


}
