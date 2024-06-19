package edu.comp438.hotelmanagementsystem.repository;

import edu.comp438.hotelmanagementsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name); // Assuming the role name is stored in a field called 'name'
}
