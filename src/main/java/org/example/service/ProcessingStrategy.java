package org.example.service;

import org.example.model.BankProduct;

public interface ProcessingStrategy {
    void process(BankProduct bankProduct);
}
