package org.example.repository;

import org.example.model.BankProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankRepository {
    private final List<BankProduct> bookings;

    public BankRepository() {
        bookings = new ArrayList<>();
    }

    public BankRepository(List<BankProduct> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(BankProduct booking) {
        bookings.add(booking);
    }

    public List<BankProduct> getAllBookings() {
        return bookings;
    }

    public Optional<BankProduct> getBookingByAccountNumber(String accountNumber) {
        return bookings.stream()
                .filter(booking -> booking.getAccountNumber().equals(accountNumber))
                .findFirst();
    }

    public void removeBookingByAccountNumber(String accountNumber) {
        bookings.removeIf(booking -> booking.getAccountNumber().equals(accountNumber));
    }
}
