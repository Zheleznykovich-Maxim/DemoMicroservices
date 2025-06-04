package com.example.paymentservice.kafka;

import com.example.paymentservice.domain.dto.InstallmentCreatedEvent;
import com.example.paymentservice.domain.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InstallmentCreatedConsumer {

    private final ObjectMapper objectMapper;
    private final PaymentRepository repository;

    @KafkaListener(topics = "installment.created", groupId = "payment-service")
    public void consume(String message) throws JsonProcessingException {
        InstallmentCreatedEvent event = objectMapper.readValue(message, InstallmentCreatedEvent.class);
        Long installmentId = event.getId();
        BigDecimal totalAmount = event.getAmount();
        int months = event.getMonths();
        LocalDate startDate = event.getStartDate();

        BigDecimal monthlyPayment = totalAmount.divide(BigDecimal.valueOf(months), RoundingMode.HALF_UP);

        for (int i = 1; i <= months; i++) {
            Payment payment = new Payment();
            payment.setInstallmentId(installmentId);
            payment.setMonthNumber(i);
            payment.setAmount(monthlyPayment);
            payment.setDueDate(startDate.plusMonths(i - 1));
            payment.setPaid(false);
            repository.save(payment);
        }

        System.out.println("✅ Created payment schedule for installment ID: " + installmentId);
    }
}
