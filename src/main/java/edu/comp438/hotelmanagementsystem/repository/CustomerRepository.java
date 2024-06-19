package edu.comp438.hotelmanagementsystem.repository;

import edu.comp438.hotelmanagementsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
