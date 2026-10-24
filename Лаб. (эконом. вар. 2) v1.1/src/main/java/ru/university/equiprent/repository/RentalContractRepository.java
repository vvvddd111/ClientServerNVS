package ru.university.equiprent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.model.RentalContract;

public interface RentalContractRepository extends JpaRepository<RentalContract, Long> {

    @EntityGraph(attributePaths = {
    "items", 
    "items.equipment", 
    "client", 
    "createdBy", 
    "createdBy.roles", 
    "createdBy.roles.permissions", 
    "approvedBy", 
    "approvedBy.roles", 
    "approvedBy.roles.permissions"
})
    Optional<RentalContract> findById(Long id);
}
