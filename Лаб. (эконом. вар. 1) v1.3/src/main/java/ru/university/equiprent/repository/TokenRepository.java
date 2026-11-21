package ru.university.equiprent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.model.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
