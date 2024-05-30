package org.example.exception;

import java.io.IOException;

public class FailedToParseAccountsException extends Exception {
    private final IOException exception;

    public FailedToParseAccountsException(IOException exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "Failed to parse accounts: " + exception.getMessage();
    }
}
