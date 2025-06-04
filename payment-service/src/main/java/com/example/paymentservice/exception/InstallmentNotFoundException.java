package com.example.paymentservice.exception;

public class InstallmentNotFoundException extends RuntimeException {
    public InstallmentNotFoundException(Long id) {
        super("Installment not found with id " + id);
    }
}
