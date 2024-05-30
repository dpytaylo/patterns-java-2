package org.example.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.builder.BankProductBuilder;
import org.example.decorator.OverdraftProtection;
import org.example.exception.FailedToParseAccountsException;
import org.example.factory.BankAccountFactory;
import org.example.model.BankProduct;
import org.example.repository.BankRepository;
import org.example.service.InterestCalculationStrategy;
import org.example.service.OverdraftPenaltyStrategy;
import org.example.service.ProcessingStrategy;

public class BankApplication {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws FailedToParseAccountsException {
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        BankRepository repository = bankAccountFactory.parseJsonFromFile("src/main/resources/input.json");

        BankProduct bankAccount = new BankProductBuilder()
            .setAccountNumber("1")
            .setBalance(1000)
            .build();

        BankProduct bankAccountWithOverdraft = new OverdraftProtection(bankAccount, 2000);
        logger.info("bankAccountWithOverdraft = " + bankAccountWithOverdraft);

        ProcessingStrategy interestStrategy = new InterestCalculationStrategy(0.05);
        interestStrategy.process(bankAccountWithOverdraft);

        ProcessingStrategy overdraftPenaltyStrategy = new OverdraftPenaltyStrategy(0.10);
        overdraftPenaltyStrategy.process(bankAccountWithOverdraft);

        BankProduct bankAccount2 = repository
            .getBookingByAccountNumber("2")
            .orElseThrow();

        BankProduct bankAccountWithOverdraft2 = new OverdraftProtection(bankAccount2, 2000);
        logger.info("bankAccountWithOverdraft2 = " + bankAccountWithOverdraft2);
    }
}
