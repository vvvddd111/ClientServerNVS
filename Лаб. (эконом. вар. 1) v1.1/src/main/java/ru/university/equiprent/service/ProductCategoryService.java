package ru.university.equiprent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.model.Category;
import ru.university.equiprent.repository.ProductCategoryRepository;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category create(Category category) {
        return repository.save(category);
    }
}
