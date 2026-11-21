package ru.university.equiprent.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ru.university.equiprent.dto.ReportRequestedEvent;
import ru.university.equiprent.dto.SaleRequest;
import ru.university.equiprent.model.RentalContract;
import ru.university.equiprent.model.SaleContract;
import ru.university.equiprent.repository.SaleContractRepository;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleContractRepository saleContractRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public SaleContract create(SaleRequest entity) {
        SaleContract saved = saleContractRepository.save(entity);

        eventPublisher.publishEvent(new ReportRequestedEvent(
                UUID.randomUUID().toString(),
                saved.getId(),
                LocalDateTime.now()
        ));

        return saved;
    }


    public SaleContract getById(Long id){
        return  saleContractRepository.findById(id).orElseThrow();
    }
}