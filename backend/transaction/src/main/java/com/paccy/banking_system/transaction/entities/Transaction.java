package com.paccy.banking_system.transaction.entities;

import com.paccy.banking_system.transaction.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Integer id;
    private String transactionId;
    private Integer fromAccount;
    private Integer toAccount;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private Status status;
}
