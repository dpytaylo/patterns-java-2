package org.example.app.service;

import org.example.app.model.BankProduct;

public interface ProcessingStrategy {
    void process(BankProduct bankProduct);
}
