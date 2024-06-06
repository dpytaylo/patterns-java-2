package org.example.app.decorator;

import org.example.app.model.BankProduct;

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
