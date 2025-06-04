package org.example.installmentservice.service;

import lombok.AllArgsConstructor;
import org.example.installmentservice.domain.model.Installment;
import org.example.installmentservice.exception.InstallmentNotFoundException;
import org.example.installmentservice.repository.InstallmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstallmentService {

    private final InstallmentRepository installmentRepository;

    public Installment createInstallment(Installment installment) {
        return installmentRepository.save(installment);
    }

    public List<Installment> getAllInstallments() {
        return installmentRepository.findAll();
    }

    public Installment getInstallmentById(Long id) {
        return installmentRepository.findById(id).orElseThrow(() -> new InstallmentNotFoundException(id));
    }

    public Installment updateInstallment(Installment installment) {
        return installmentRepository.save(installment);
    }
}
