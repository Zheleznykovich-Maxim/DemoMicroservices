package org.example.installmentservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.example.installmentservice.domain.model.Installment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstallmentEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendInstallmentCreatedEvent(Installment installment) throws JsonProcessingException {
        String topic = "installment.created";
        String message = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writeValueAsString(installment);
        kafkaTemplate.send(topic, message);
    }
}
