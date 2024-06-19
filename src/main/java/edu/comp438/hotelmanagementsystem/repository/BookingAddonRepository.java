package edu.comp438.hotelmanagementsystem.repository;

import edu.comp438.hotelmanagementsystem.entity.BookingAddon;
import edu.comp438.hotelmanagementsystem.entity.BookingAddonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingAddonRepository extends JpaRepository<BookingAddon, BookingAddonId> {
}
