package com.example.paymentservice.service;

import com.example.paymentservice.domain.model.Payment;
import com.example.paymentservice.exception.InstallmentNotFoundException;
import com.example.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Cacheable(value = "payments", key = "#installmentId")
    public List<Payment> getPaymentsByInstallmentId(Long installmentId) {

        boolean exists = paymentRepository.existsByInstallmentId(installmentId);
        if (!exists) {
            throw new InstallmentNotFoundException(installmentId);
        }
        System.out.println("Loading payments from DB for installmentId = " + installmentId);
        log.info("Installment found with id: {}", installmentId);
        return paymentRepository.findByInstallmentId(installmentId);
    }

    @CachePut(value = "payments", key = "#payment.installmentId")
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @CacheEvict(value = "payments", key = "#installmentId")
    public void deletePayments(Long installmentId) {
        paymentRepository.deleteByInstallmentId(installmentId);
    }
}
