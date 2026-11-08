package ru.university.equiprent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.model.Category;

public interface ProductCategoryRepository extends
        JpaRepository<Category, Long> {
        List<Category> findByName(String name);
}
