package ru.university.equiprent.repository.spec;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import ru.university.equiprent.model.Product;
import ru.university.equiprent.model.Supplier;

public class ProductSpecifications {
    public static Specification<Product> withFilter(
            Long categoryId,
            Long supplierId,
            String title) {
        return Specification.allOf(
                categoryIdEquals(categoryId),
                supplierIdEquals(supplierId),
                titleContains(title));

    }

    private static Specification<Product> categoryIdEquals(Long categoryId) {

        return (root, query, cb) -> {
            if (categoryId == null)
                return null;
            return cb.equal(root.get("category").get("id"), categoryId);
        };
    }

    private static Specification<Product> supplierIdEquals(Long supplierId) {

        return (root, query, cb) -> {
            if (supplierId == null)
                return null;
            return cb.equal(root.get("supplier").get("id"), supplierId);
        };

    }

    private static Specification<Product> titleContains(String title) {

        return (root, query, cb) -> {
            if (title == null || title.isBlank() || title.trim().isEmpty())
                return null;
            return cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
        };

    }
}
