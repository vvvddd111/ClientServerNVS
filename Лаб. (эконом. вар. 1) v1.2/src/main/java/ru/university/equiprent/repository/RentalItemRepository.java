package ru.university.equiprent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.model.RentalItem;

public interface RentalItemRepository  extends JpaRepository<RentalItem, Long>{

}
