package ru.university.equiprent.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import ru.university.equiprent.model.Client;
import ru.university.equiprent.model.User;

public record SaleRequest(
    Client client, LocalDate saleDate, User createdBy,
            List items, BigDecimal totalAmount
) {

}
