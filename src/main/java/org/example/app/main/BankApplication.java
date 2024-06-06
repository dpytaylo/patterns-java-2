package org.example.app.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.app.model.BankAccount;
import org.example.app.decorator.OverdraftProtection;
import org.example.app.exception.FailedToParseAccountsException;
import org.example.app.factory.impl.BankAccountFactory;
import org.example.app.model.BankProduct;
import org.example.app.reader.BankAccountReader;
import org.example.app.repository.BankRepository;
import org.example.app.service.impl.InterestCalculationStrategy;
import org.example.app.service.impl.OverdraftPenaltyStrategy;
import org.example.app.service.ProcessingStrategy;

public class BankApplication {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws FailedToParseAccountsException {
        BankAccountReader reader = new BankAccountReader();

        BankRepository repository = new BankRepository(
            reader.readFromJsonFile("src/main/resources/input.json")
        );

        BankAccountFactory factory = new BankAccountFactory();
        BankProduct bankAccount0 = factory.createBankProduct("0", 2000);

        BankProduct bankAccountWithOverdraft0 = new OverdraftProtection(bankAccount0, 23000);
        logger.info("bankAccountWithOverdraft0 = " + bankAccountWithOverdraft0);

        BankAccount bankAccount1 = BankAccount.builder()
            .setAccountNumber("1")
            .setBalance(1000)
            .setAccountName("Account Maksim")
            .build();

        BankProduct bankAccountWithOverdraft1 = new OverdraftProtection(bankAccount1, 2000);
        logger.info("bankAccountWithOverdraft1 = " + bankAccountWithOverdraft1);

        ProcessingStrategy interestStrategy1 = new InterestCalculationStrategy(0.05);
        interestStrategy1.process(bankAccountWithOverdraft1);

        ProcessingStrategy overdraftPenaltyStrategy1 = new OverdraftPenaltyStrategy(0.10);
        overdraftPenaltyStrategy1.process(bankAccountWithOverdraft1);

        BankProduct bankAccount2 = repository
            .getBookingByAccountNumber("2")
            .orElseThrow();

        BankProduct bankAccountWithOverdraft2 = new OverdraftProtection(bankAccount2, 2000);
        logger.info("bankAccountWithOverdraft2 = " + bankAccountWithOverdraft2);
    }
}
