package org.example.decorator;

import org.example.model.BankProduct;

public class OverdraftProtection extends BankProductDecorator {
    private final long overdraftLimit;

    public OverdraftProtection(BankProduct decoratedBankProduct, long overdraftLimit) {
        super(decoratedBankProduct);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String toString() {
        return super.toString() + "; Overdraft Limit: " + overdraftLimit;
    }
}
