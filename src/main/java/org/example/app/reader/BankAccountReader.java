package org.example.app.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.app.model.BankAccount;
import org.example.app.exception.FailedToParseAccountsException;
import org.example.app.model.BankProduct;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountReader {
    public List<BankProduct> readFromJsonFile(String filename) throws FailedToParseAccountsException {
        List<BankProduct> accounts = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filename));
            for (JsonNode node : rootNode) {
                String accountNumber = node.get("accountNumber").asText();
                long balance = node.get("balance").asLong();

                BankProduct bankAccount = new BankAccount(accountNumber, balance, "Untitled");
                accounts.add(bankAccount);
            }
        } catch (IOException e) {
            throw new FailedToParseAccountsException(e);
        }

        return accounts;
    }
}
