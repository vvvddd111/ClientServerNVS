package ru.university.equiprent.service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ru.university.equiprent.dto.RentalContractRequest;
import ru.university.equiprent.model.Client;
import ru.university.equiprent.model.Equipment;
import ru.university.equiprent.model.RentalContract;
import ru.university.equiprent.model.RentalItem;
import ru.university.equiprent.model.User;
import ru.university.equiprent.repository.ClientRepository;
import ru.university.equiprent.repository.EquipmentRepository;
import ru.university.equiprent.repository.RentalContractRepository;
import ru.university.equiprent.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class RentalContractService {

    private final RentalContractRepository repository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository; // временно до Spring Security
    private final EquipmentRepository equipmentRepository;

    @Transactional 
    public RentalContract create(RentalContractRequest request) {
        Client client = clientRepository.findById(request.clientId()).orElseThrow();
        Equipment equipment = equipmentRepository.findById(request.equipmentId()).orElseThrow();
        User anyUser = userRepository.findAll().stream().findFirst().orElseThrow();

        long days = ChronoUnit.DAYS.between(request.startDate(), request.endDate());
        BigDecimal lineTotal = equipment.getDailyRate().multiply(BigDecimal.valueOf(request.quantity() * days));
        RentalContract contract = RentalContract.builder()
                .client(client).startDate(request.startDate()).endDate(request.endDate())
                .createdBy(anyUser).totalAmount(lineTotal).build();
        contract.addItem(RentalItem.builder().equipment(equipment)
                .dailyRate(equipment.getDailyRate())
                .quantity(request.quantity()).days((int) days)
                .lineTotal(lineTotal).build());
        return repository.save(contract);
    }

    public RentalContract getById(Long id){
        return  repository.findById(id).orElseThrow();
    }
}
