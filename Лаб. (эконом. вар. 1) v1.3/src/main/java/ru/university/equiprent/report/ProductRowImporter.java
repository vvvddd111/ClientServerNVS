package ru.university.equiprent.report;


import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.model.Category; 
import ru.university.equiprent.model.Product;
import ru.university.equiprent.model.Supplier;
import ru.university.equiprent.repository.ProductCategoryRepository;
import ru.university.equiprent.repository.ProductRepository;
import ru.university.equiprent.repository.SupplierRepository;

@Component
@RequiredArgsConstructor  
public class ProductRowImporter {
    private final ProductRepository repository;
    private final ProductCategoryRepository productCategoryRepository;
    private final SupplierRepository supplierRepository;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void importRow(String title, String categoryName, String supplierName, int price) {
        Supplier supplier = supplierRepository.findByName(supplierName).orElseGet(
                () -> supplierRepository.save(
                        Supplier.builder().name(supplierName).build()));;
        Category categoryProd = productCategoryRepository.findByName(categoryName).orElseGet(
                () -> productCategoryRepository.save(
                        Category.builder().name(categoryName).build()));
        repository.save(Product.builder()
                .title(title).category(categoryProd)
                .supplier(supplier).price( price)
                .build());
    }
}
