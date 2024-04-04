package com.example.bankms.services.Impl;

import com.example.bankms.models.BankAccount;
import com.example.bankms.services.BankAccountService;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.NotSupportedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.bankms.repositories.BankAccountRepository;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    final BankAccountRepository bankRepository;

    @Override
    public void transferGrant(String accountNumber, Double grant) {
        BankAccount account = bankRepository.findBankAccountsByAccountNumber(accountNumber).orElseThrow(()->new NotFoundException("not found accountNumber"));
        account.setBalance(account.getBalance() + grant);
        bankRepository.save(account);

    }

    @Override
    public void debitGrant(String accountNumber, Double grant) {
        BankAccount account = bankRepository.findBankAccountsByAccountNumber(accountNumber).orElseThrow(()->new NotFoundException("not found accountNumber"));
        if (account.getBalance() < grant) throw new NotSupportedException("Not enough money");
        account.setBalance(account.getBalance() - grant);
        bankRepository.save(account);
    }

    @Override
    public Double getBalance(String accountNumber) {
        BankAccount account = bankRepository.findBankAccountsByAccountNumber(accountNumber).orElseThrow(()->new NotFoundException("not found accountNumber"));
        return account.getBalance();
    }

    public String createBankAccount(String firstName, String lastName) {

        String accountNumber;
        do {
            accountNumber = Integer.toString(ThreadLocalRandom.current().nextInt(100_000, 1_000_000));
        }
        while (bankRepository.findBankAccountsByAccountNumber(accountNumber).isPresent());

        BankAccount newBankAccount = BankAccount.builder()
                .accountNumber(accountNumber)
                .firstName(firstName)
                .lastName(lastName)
                .balance(0d)
                .build();
        bankRepository.save(newBankAccount);
        return newBankAccount.getAccountNumber();
    }

    public void updateName(String accountNumber, String firstName, String lastName){
        BankAccount bankAccount = bankRepository.findBankAccountsByAccountNumber(accountNumber).orElseThrow(()->new NotFoundException("not found accountNumber"));
        bankAccount.setFirstName(firstName);
        bankAccount.setLastName(lastName);
        bankRepository.save(bankAccount);
    }
}
