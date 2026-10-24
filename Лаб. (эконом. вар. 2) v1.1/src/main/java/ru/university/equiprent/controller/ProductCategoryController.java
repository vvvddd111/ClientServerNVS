package ru.university.equiprent.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ru.university.equiprent.model.Category;
import ru.university.equiprent.service.ProductCategoryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product_category")
@Tag(name = "Product Category Controller")
public class ProductCategoryController {
    private final ProductCategoryService service;

    @GetMapping()
    public List<Category> getAll() {
        return service.findAll();
    }
    @PostMapping()
    public Category create(@RequestBody Category request) {
        return service.create(request);
    }

}
