package org.example.installmentservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.example.installmentservice.domain.model.Installment;
import org.example.installmentservice.kafka.InstallmentEventProducer;
import org.example.installmentservice.repository.InstallmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/installments")
@RequiredArgsConstructor
public class InstallmentController {

    private final InstallmentRepository repository;
    private final InstallmentEventProducer producer;

    @PostMapping
    public ResponseEntity<Installment> create(@RequestBody Installment installment) throws JsonProcessingException {
        Installment saved = repository.save(installment);
        producer.sendInstallmentCreatedEvent(saved);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Installment> get(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
