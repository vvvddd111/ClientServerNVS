package ru.university.equiprent.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostProductsRequest(
    @NotBlank(message = "Title cannot be blank") String title,
    @NotNull(message = "price cannnot be Null or Empty")  
    @DecimalMin(value = "0.01", 
    message = "price cannot be lower then 0")
    int price
) {

}
