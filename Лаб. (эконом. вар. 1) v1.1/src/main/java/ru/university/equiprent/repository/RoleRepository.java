package ru.university.equiprent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByTitle(String title);
}
