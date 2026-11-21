package ru.university.equiprent.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.dto.UserDto;
import ru.university.equiprent.exception.ApiException;
import ru.university.equiprent.exception.ResourceNotFoundException;
import ru.university.equiprent.mapper.UserMapper;
import ru.university.equiprent.model.Role;
import ru.university.equiprent.model.User;
import ru.university.equiprent.repository.RoleRepository;
import ru.university.equiprent.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::userToUserDto).toList();
    }

    public UserDto create(UserDto userDto) {
        User user = UserMapper.userDtoToUser(userDto);

        // Находим все роли, перечисленные в UserDto
        Set<Role> roles = new HashSet<>();
        if (userDto.role() != null) {
            for (String roleTitle : userDto.role()) {
                Role role = roleRepository.findByTitle(roleTitle).orElseThrow(
                        () -> new ResourceNotFoundException("Role not found: " + roleTitle));
                roles.add(role);
            }
        }

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(userDto.password()));

        return UserMapper.userToUserDto(userRepository.save(user));
    }

    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found"));
        return UserMapper.userToUserDto(user);
    }

    public UserDto getUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User not found"));
        return UserMapper.userToUserDto(user);
    }

    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found"));

        // Находим обновленный список ролей
        Set<Role> roles = new HashSet<>();
        if (userDto.role() != null) {
            for (String roleTitle : userDto.role()) {
                Role role = roleRepository.findByTitle(roleTitle).orElseThrow(
                        () -> new ResourceNotFoundException("Role not found: " + roleTitle));
                roles.add(role);
            }
        }

        user.setUsername(userDto.username());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setRoles(roles);

        return UserMapper.userToUserDto(userRepository.save(user));
    }

    public String deleteUser(Long userId) {
        // get user from db
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException( "User not found"));

        userRepository.delete(user);

        return String.format("User with %d deleted successfully", userId);
    }

}