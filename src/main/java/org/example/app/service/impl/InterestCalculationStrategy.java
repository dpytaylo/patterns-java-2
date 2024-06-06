package org.example.app.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.app.model.BankProduct;
import org.example.app.service.ProcessingStrategy;

public class InterestCalculationStrategy implements ProcessingStrategy {
    private static final Logger logger = LogManager.getLogger();

    private final double interestRate;

    public InterestCalculationStrategy(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void process(BankProduct bankProduct) {
        double interest = bankProduct.getBalance() * interestRate;
        logger.info("Interest Calculated: " + interest);
    }
}
