package ru.university.equiprent.api;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import ru.university.equiprent.dto.EquipmentRequest;
import ru.university.equiprent.dto.EquipmentResponse;

@RequestMapping("/api/products")
@Tag(name = "Add Products")
public interface PostProducts {
        @PostMapping
        public EquipmentResponse create(
                        @RequestBody @Valid EquipmentRequest entity);
}
