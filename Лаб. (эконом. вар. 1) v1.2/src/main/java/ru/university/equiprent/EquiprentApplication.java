package ru.university.equiprent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching 
@SpringBootApplication
public class EquiprentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquiprentApplication.class, args);
	}

}
