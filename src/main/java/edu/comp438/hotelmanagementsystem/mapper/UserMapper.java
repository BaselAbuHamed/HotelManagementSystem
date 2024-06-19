package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.UserDTO;
import edu.comp438.hotelmanagementsystem.entity.Role;
import edu.comp438.hotelmanagementsystem.entity.User;
import edu.comp438.hotelmanagementsystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final RoleRepository roleRepository;

    @Autowired
    public UserMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserDTO toDto(User user) {
        String roleName = user.getRoles().stream()
                .map(Role::getName)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User has no roles"));

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                roleName
        );
    }

    public User toEntity(UserDTO userDTO) {
        Role role = roleRepository.findByName(userDTO.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found: " + userDTO.getRole()));

        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRoles(Collections.singleton(role));

        return user;
    }
}
