package ru.university.equiprent.dto;


import java.time.LocalDate;

import ru.university.equiprent.model.EquipmentStatus;

public record ProductsResponse(
    private Long id;
    private String title;
    private Category category;
    private Supplier supplier;
    private int price;
    private int stockQuantity;
    private LocalDate lastRestockedAt;
) {
    
}

