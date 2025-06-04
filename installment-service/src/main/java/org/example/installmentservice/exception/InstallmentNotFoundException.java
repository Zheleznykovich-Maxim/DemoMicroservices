package org.example.installmentservice.exception;

public class InstallmentNotFoundException extends RuntimeException {
    public InstallmentNotFoundException(Long id) {
        super("Installment not found with id " + id);
    }
}
