package com.example.paymentservice.repository;

import com.example.paymentservice.domain.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByInstallmentId(Long installmentId);

    void  deleteByInstallmentId(Long installmentId);

    Boolean existsByInstallmentId(Long installmentId);
}
