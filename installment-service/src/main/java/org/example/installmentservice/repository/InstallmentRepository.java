package org.example.installmentservice.repository;

import org.example.installmentservice.domain.model.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {
}
