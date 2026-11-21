package ru.university.equiprent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.dto.SaleRequest;
import ru.university.equiprent.model.SaleContract;

public interface SaleContractRepository extends JpaRepository<SaleContract, Long> {

    @EntityGraph(attributePaths = {
    "products",  
    "client", 
    "createdBy", 
    "createdBy.roles", 
    "createdBy.roles.permissions", 
    "approvedBy", 
    "approvedBy.roles", 
    "approvedBy.roles.permissions"
})
    default
    Optional<SaleContract> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    SaleContract save(SaleRequest entity);
}
