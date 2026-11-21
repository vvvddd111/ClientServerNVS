package ru.university.equiprent.controller;

import java.io.IOException;
import java.io.UncheckedIOException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.api.ProductApi;
import ru.university.equiprent.dto.CsvImportResult;
import ru.university.equiprent.dto.ProductRequest;
import ru.university.equiprent.dto.ProductResponse;
import ru.university.equiprent.report.ImportService;
import ru.university.equiprent.service.ProductService;

@RequiredArgsConstructor
@RestController
public class ProductController implements ProductApi {
    private final ProductService service;
    private final ImportService importService;

    public Page<ProductResponse> getAll(Long categoryId, Long suplierId,
            String title, Pageable pageable) {
        return service.search(categoryId, suplierId,
                title, pageable);
    }

    public ProductResponse get(Long id) {
        return service.findById(id);
    }

    public ProductResponse create(ProductRequest request) {
        return service.create(request);
    }

    public ProductResponse update(ProductRequest request, Long id) {
        return service.update(request, id);
    }

    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    public String uploadPhoto(Long id, MultipartFile file) {
        return service.uploadPhoto(id, file);
    }

    public CsvImportResult importCsv(MultipartFile file) {
        try {
            return importService.importCsv(file.getInputStream());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}