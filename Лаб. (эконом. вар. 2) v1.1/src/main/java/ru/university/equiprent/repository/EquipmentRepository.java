package ru.university.equiprent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ru.university.equiprent.model.Equipment;

public interface EquipmentRepository extends
        JpaRepository<Equipment, Long>, JpaSpecificationExecutor<Equipment> {
    boolean existsBySerialNumber(String serialNumber);
}
