package org.example.factory.impl;

import org.example.factory.BankProductFactory;
import org.example.model.BankAccount;
import org.example.model.BankProduct;

public class BankAccountFactory implements BankProductFactory {
    @Override
    public BankProduct createBankProduct(String accountNumber, long balance) {
        return new BankAccount(accountNumber, balance, "Untitled");
    }
}
