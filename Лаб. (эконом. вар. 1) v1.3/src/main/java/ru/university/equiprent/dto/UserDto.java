package ru.university.equiprent.dto;

import java.io.Serializable;
import java.util.Set;

public record UserDto(
                Long id,
                String username,
                String password,
                Set<String> role,
                Set<String> permissions) implements Serializable {
}