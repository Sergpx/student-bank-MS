package com.example.bankms.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Table(name = "banks")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String accountNumber;
    @Setter
    Double balance;



}
