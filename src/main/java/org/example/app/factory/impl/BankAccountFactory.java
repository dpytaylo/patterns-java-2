package org.example.app.factory.impl;

import org.example.app.factory.BankProductFactory;
import org.example.app.model.BankAccount;
import org.example.app.model.BankProduct;

public class BankAccountFactory implements BankProductFactory {
    @Override
    public BankProduct createBankProduct(String accountNumber, long balance) {
        return new BankAccount(accountNumber, balance, "Untitled");
    }
}
