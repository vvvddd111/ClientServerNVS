package ru.university.equiprent.api;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import ru.university.equiprent.dto.ProductRequest;
import ru.university.equiprent.dto.ProductResponse;

@RequestMapping("/api/product")
@Tag(name = "Product Controller")
public interface ProductApi {
        @GetMapping()
        public Page<ProductResponse> getAll(@RequestParam(required = false) Long category,
                        @RequestParam(required = false) Long suplierId,
                        @RequestParam(required = false) String title,
                        @ParameterObject @PageableDefault(page = 0, size = 10, sort = "title") Pageable pageable);



        @GetMapping("/{id}")
        public ProductResponse get(
                        @RequestParam Long id);

        @PostMapping
        public ProductResponse create(
                        @RequestBody @Valid ProductRequest entity);

        @PutMapping
        public ProductResponse update(
                        @RequestBody @Valid ProductRequest entity, Long id);

        @DeleteMapping
        public ResponseEntity<Void> delete(Long id);
}
