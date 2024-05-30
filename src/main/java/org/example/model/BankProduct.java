package org.example.model;

public abstract class BankProduct {
    protected String accountNumber;
    protected long balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "; Balance: " + balance;
    }
}
