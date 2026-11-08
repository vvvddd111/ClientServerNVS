package ru.university.equiprent.report;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.model.Category; 
import ru.university.equiprent.model.Product;
import ru.university.equiprent.model.Supplier;
import ru.university.equiprent.repository.ProductCategoryRepository;
import ru.university.equiprent.repository.ProductRepository;

@Component
@RequiredArgsConstructor  
public class ProductRowImporter {
    private final ProductRepository repository;
    private final ProductCategoryRepository productCategoryRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void importRow(String title, String categoryName, Supplier supplier, int price) {
        Category categoryProd = productCategoryRepository.findByName(categoryName).orElseGet(
                () -> productCategoryRepository.save(
                        Category.builder().name(categoryName).build()));
        repository.save(Product.builder()
                .title(title).category(categoryProd)
                .supplier(supplier).price(price)
                .build());
    }
}
