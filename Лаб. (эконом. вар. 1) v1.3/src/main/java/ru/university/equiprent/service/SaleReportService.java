package ru.university.equiprent.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ru.university.equiprent.model.SaleContract;
import ru.university.equiprent.repository.SaleContractRepository;

@Service
@RequiredArgsConstructor
public class SaleReportService {
    private final SaleContractRepository saleContractRepository;

    @Transactional
    public String generate(Long saleId) {
        SaleContract sale = saleContractRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale " + saleId));

        // sale.getItems(), sale.getClient() — уже внутри сессии
        // вернуть статус
        return "COMPLETED";
    }
}