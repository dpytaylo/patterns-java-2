package org.example.factory;

import org.example.model.BankProduct;

public interface BankProductFactory {
    BankProduct createBankProduct(String accountName, long balance);
}
