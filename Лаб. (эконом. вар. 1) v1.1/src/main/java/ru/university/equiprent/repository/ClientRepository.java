package ru.university.equiprent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
