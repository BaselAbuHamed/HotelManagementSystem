package edu.comp438.hotelmanagementsystem.repository;

import edu.comp438.hotelmanagementsystem.entity.BookingRoom;
import edu.comp438.hotelmanagementsystem.entity.BookingRoomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRoomRepository extends JpaRepository<BookingRoom, BookingRoomId> {
    List<BookingRoom> findByBookingId(Long bookingId);

}
