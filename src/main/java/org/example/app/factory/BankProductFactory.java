package org.example.app.factory;

import org.example.app.model.BankProduct;

public interface BankProductFactory {
    BankProduct createBankProduct(String accountName, long balance);
}
