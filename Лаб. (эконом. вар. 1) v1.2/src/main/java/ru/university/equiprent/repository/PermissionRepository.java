package ru.university.equiprent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByPermissionAndOperation(String permission, String operation);
}
