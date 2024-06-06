package org.example.exception;

import java.io.IOException;

public class FailedToParseAccountsException extends Exception {
    public FailedToParseAccountsException(IOException exception) {
        super(exception);
    }

    @Override
    public String toString() {
        return "Failed to parse accounts";
    }
}
