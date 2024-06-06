package org.example.model;

public class BankAccount extends BankProduct {
    protected String accountName;

    private BankAccount() {}

    public BankAccount(String accountNumber, long balance, String accountName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "; Balance: " + balance + "; Name: " + accountName;
    }

    public static Builder builder() {
        return new BankAccount().new Builder();
    }

    public class Builder {
        private Builder() {}

        public Builder setAccountNumber(String accountNumber) {
            BankAccount.this.accountNumber = accountNumber;
            return this;
        }

        public Builder setBalance(long balance) {
            BankAccount.this.balance = balance;
            return this;
        }

        public Builder setAccountName(String accountName) {
            BankAccount.this.accountName = accountName;
            return this;
        }

        public BankAccount build() {
            return BankAccount.this;
        }
    }
}
