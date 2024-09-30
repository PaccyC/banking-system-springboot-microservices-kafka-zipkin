package com.paccy.transaction.entities;

import com.paccy.transaction.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
