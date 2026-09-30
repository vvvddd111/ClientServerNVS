package ru.university.equiprent.model;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.User;

public class Sale {
    private Long id;
    private Store store;
    private List<SaleItem> items;
    private LocalDateTime soldAt;
    private User cashier;
}
