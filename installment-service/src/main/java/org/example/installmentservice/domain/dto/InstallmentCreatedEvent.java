package org.example.installmentservice.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class InstallmentCreatedEvent {
    private Long id;
    private String customerId;
    private BigDecimal amount;
    private int months;
    private LocalDate startDate;
}
