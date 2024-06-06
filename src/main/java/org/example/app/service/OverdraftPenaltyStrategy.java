package org.example.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.app.model.BankProduct;

public class OverdraftPenaltyStrategy implements ProcessingStrategy {
    private static final Logger logger = LogManager.getLogger();
    private final double penaltyRate;

    public OverdraftPenaltyStrategy(double penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    @Override
    public void process(BankProduct bankProduct) {
        if (bankProduct.getBalance() < 0) {
            double penalty = Math.abs(bankProduct.getBalance()) * penaltyRate;
            logger.info("Overdraft Penalty Calculated: " + penalty);
        } else {
            logger.info("No overdraft penalty applied. Balance is positive.");
        }
    }
}