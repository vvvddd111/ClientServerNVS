package ru.university.equiprent.dto;


public record LoginResponse(
        boolean isLogged,
        String roles
) {
}
