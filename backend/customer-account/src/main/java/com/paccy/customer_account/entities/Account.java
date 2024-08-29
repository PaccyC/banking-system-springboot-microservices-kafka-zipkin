package com.paccy.customer_account.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private Integer customerId;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String balance;

    @Column( updatable = false)
    @CreatedDate
    private LocalDate createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDate updateDate;

}
