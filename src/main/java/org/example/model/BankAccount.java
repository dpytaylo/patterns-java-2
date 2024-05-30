package org.example.model;

public class BankAccount extends BankProduct {
    public BankAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
