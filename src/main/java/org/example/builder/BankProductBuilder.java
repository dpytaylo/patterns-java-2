package org.example.builder;

import org.example.model.BankAccount;
import org.example.model.BankProduct;

public class BankProductBuilder {
    private String accountNumber;
    private long balance;

    public BankProductBuilder setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public BankProductBuilder setBalance(long balance) {
        this.balance = balance;
        return this;
    }

    public BankProduct build() {
        return new BankAccount(accountNumber, balance);
    }
}
