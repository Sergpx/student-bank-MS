package com.example.bankms.repositories;

import com.example.bankms.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    Optional<BankAccount> findBankAccountsByAccountNumber(String accountNumber);

}
