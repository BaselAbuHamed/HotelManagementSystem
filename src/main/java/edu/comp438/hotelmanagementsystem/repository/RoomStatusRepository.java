package edu.comp438.hotelmanagementsystem.repository;

import edu.comp438.hotelmanagementsystem.entity.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomStatusRepository extends JpaRepository<RoomStatus, Long> {
}
