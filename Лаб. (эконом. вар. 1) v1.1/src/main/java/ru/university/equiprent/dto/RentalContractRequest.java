package ru.university.equiprent.dto;

import java.time.LocalDate;

public record RentalContractRequest(
    Long clientId, LocalDate startDate, LocalDate endDate,
            Long equipmentId, int quantity
) {

}
