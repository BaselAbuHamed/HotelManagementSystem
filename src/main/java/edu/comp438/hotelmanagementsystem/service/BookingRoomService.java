package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.BookingRoomDTO;

import java.util.List;

public interface BookingRoomService {
    BookingRoomDTO createBookingRoom(BookingRoomDTO bookingRoomDTO);
    BookingRoomDTO updateBookingRoom(Long bookingId, Long roomId, BookingRoomDTO bookingRoomDTO);
    BookingRoomDTO getBookingRoomById(Long bookingId, Long roomId);
    void deleteBookingRoom(Long bookingId, Long roomId);
    List<BookingRoomDTO> getAllBookingRooms();
}
