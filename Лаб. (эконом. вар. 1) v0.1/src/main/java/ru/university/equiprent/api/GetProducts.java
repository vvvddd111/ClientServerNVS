package ru.university.equiprent.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import ru.university.equiprent.dto.EquipmentRequest;
import ru.university.equiprent.dto.EquipmentResponse;

@RequestMapping("/api/products?category=&supplier=&lowStock=true")
@Tag(name = "Equipment Controller")
public interface GetProducts {
        @GetMapping()
        public List<EquipmentResponse> getAll();

        @GetMapping("/{id}")
        public EquipmentResponse get(
                        @RequestParam чё-то там для сортировки);
}