package com.example.bankms.services;

public interface BankAccountService {


    public void transferGrant(String accountNumber, Double grant);

    public void debitGrant(String accountNumber, Double grant) throws Exception;

    public Double getBalance(String accountNumber);

    public String createBankAccount(String firstName, String lastName);

}
