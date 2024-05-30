package org.example.decorator;

import org.example.model.BankProduct;

public abstract class BankProductDecorator extends BankProduct {
    protected BankProduct decoratedBankProduct;

    public BankProductDecorator(BankProduct decoratedBankProduct) {
        this.decoratedBankProduct = decoratedBankProduct;
    }

    @Override
    public String getAccountNumber() {
        return decoratedBankProduct.getAccountNumber();
    }

    @Override
    public long getBalance() {
        return decoratedBankProduct.getBalance();
    }

    @Override
    public String toString() {
        return decoratedBankProduct.toString();
    }
}
