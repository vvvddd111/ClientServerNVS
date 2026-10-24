package ru.university.equiprent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ru.university.equiprent.dto.RentalContractRequest;
import ru.university.equiprent.model.RentalContract;
import ru.university.equiprent.service.RentalContractService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/rental_contract")
@Tag(name = "Rental Contract Controller")
public class RentalContractController {
    private final RentalContractService service;

    @PostMapping()
    public RentalContract postMethodName(@RequestBody RentalContractRequest entity) {
        return service.create(entity);

    }

    @GetMapping("/{id}")
    public RentalContract getById(@PathVariable Long id) {
        return service.getById(id);
    }

}
