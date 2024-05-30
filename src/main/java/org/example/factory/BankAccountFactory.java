package org.example.factory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.exception.FailedToParseAccountsException;
import org.example.model.BankAccount;
import org.example.repository.BankRepository;

import java.io.File;
import java.io.IOException;

public class BankAccountFactory {
    public BankRepository parseJsonFromFile(String filename) throws FailedToParseAccountsException {
        BankRepository bankRepository = new BankRepository();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filename));
            for (JsonNode node : rootNode) {
                String accountNumber = node.get("accountNumber").asText();
                long balance = node.get("balance").asLong();

                BankAccount bankAccount = new BankAccount(accountNumber, balance);
                bankRepository.addBooking(bankAccount);
            }
        } catch (IOException e) {
            throw new FailedToParseAccountsException(e);
        }

        return bankRepository;
    }
}
