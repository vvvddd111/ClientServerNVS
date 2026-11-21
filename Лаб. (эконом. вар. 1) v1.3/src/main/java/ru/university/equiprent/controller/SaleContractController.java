package ru.university.equiprent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ru.university.equiprent.dto.SaleRequest;
import ru.university.equiprent.model.RentalContract;
import ru.university.equiprent.model.SaleContract;
import ru.university.equiprent.repository.SaleContractRepository;
import ru.university.equiprent.service.SaleService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sale_contracts")
@Tag(name = "Sale Contract Controller")
public class SaleContractController {
    private final SaleService service;

    @PostMapping()
    public SaleContract postMethodName(@RequestBody SaleRequest entity) {
        return service.create(entity);

    }

    @GetMapping("/{id}")
    public SaleContract getById(@PathVariable Long id) {
        return service.getById(id);
    }

}