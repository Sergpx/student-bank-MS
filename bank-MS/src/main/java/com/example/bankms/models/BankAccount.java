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
    @Setter
    String firstName;
    @Setter
    String lastName;
    @Column(nullable = false, unique = true)
    String accountNumber;
    @Setter
    Double balance;



}
