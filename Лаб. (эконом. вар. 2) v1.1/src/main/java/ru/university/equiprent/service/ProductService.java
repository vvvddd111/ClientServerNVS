package ru.university.equiprent.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.dto.ProductRequest;
import ru.university.equiprent.dto.ProductResponse;
import ru.university.equiprent.dto.ProductRequest;
import ru.university.equiprent.dto.ProductResponse;
import ru.university.equiprent.model.Category;
import ru.university.equiprent.model.Product;
import ru.university.equiprent.model.Supplier;
import ru.university.equiprent.model.Product;
import ru.university.equiprent.repository.ProductCategoryRepository;
import ru.university.equiprent.repository.ProductRepository;
import ru.university.equiprent.repository.spec.ProductSpecifications;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
private final ProductCategoryRepository categoryRepository;
    @Transactional(readOnly = true)
    public Page<ProductResponse> search(
            Long categoryId,
            Long supplierId,
            String title, Pageable pageable) {
        return repository.findAll(ProductSpecifications.withFilter(categoryId, supplierId, title), pageable)
                .map(this::toResponse);
    }


    public ProductResponse findById(Long id) {
        return toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found ")));
    }

    @CacheEvict(cacheNames = "productCatalog", allEntries = true)
    public ProductResponse create(ProductRequest request) {

        Category category = categoryRepository
                .findById(request.category().getId()).orElseThrow(() -> new RuntimeException("Category not found "));

        Product product = Product.builder()
                .title(request.title()).category(category)
                .price(request.price())
                .build();

        return toResponse(repository.save(product));

    }

    @CacheEvict(cacheNames = "productCatalog", allEntries = true)
    public ProductResponse update(ProductRequest request, Long id) {
        Product product = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found "));
        product.setTitle(request.title());
        product.setPrice(request.price());
        product.setId(id);
        return toResponse(repository.save(product));

    }

    @CacheEvict(cacheNames = "productCatalog", allEntries = true)
    public void delete(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found "));
        repository.delete(product);

    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(product.getId(),
                product.getTitle(),
                product.getCategory(),
                product.getSupplier(),
                product.getStockQuantity(),
                product.getLastRestockedAt());
    }
}
