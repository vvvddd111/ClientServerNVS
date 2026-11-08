package ru.university.equiprent.dto;


import java.time.LocalDate;
import java.util.function.Supplier;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ru.university.equiprent.model.Category;

public record ProductRequest(
    @NotBlank(message = "Title cannot be blank") 
    String title,

    @NotNull(message = "dailyRate cannot be Null or Empty")  
    @DecimalMin(value = "0.01", message = "Price cannot be lower than 0")
    int price,

    @NotNull(message = "Supplier cannot be Null or Empty")  
    Supplier supplier,
    
    @NotNull(message = "stockQuantity cannot be Null or Empty")  
    int stockQuantity,

    @NotNull(message = "lastRestockedAt cannot be Null or Empty")  
    LocalDate lastRestockedAt,

    @NotNull(message = "category cannot be Null or Empty")
    Category category

) {

}