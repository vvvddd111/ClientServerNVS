package ru.university.equiprent.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale.Category;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class Product {
    private Long id;
    private String title;
    private Category category;
    private Supplier supplier;
    private int price;
    private int stockQuantity;
    private LocalDate lastRestockedAt;
}
