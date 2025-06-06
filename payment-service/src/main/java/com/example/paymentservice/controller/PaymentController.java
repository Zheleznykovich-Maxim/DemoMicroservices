package com.example.paymentservice.controller;

import com.example.paymentservice.domain.model.Payment;
import com.example.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/installment/{installmentId}")
    public List<Payment> getByInstallment(@PathVariable Long installmentId) {
        log.info("Test log message from installment-service");
        return paymentService.getPaymentsByInstallmentId(installmentId);
    }
}
