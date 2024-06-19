package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.BookingRoomDTO;
import edu.comp438.hotelmanagementsystem.entity.BookingRoom;
import edu.comp438.hotelmanagementsystem.entity.BookingRoomId;
import edu.comp438.hotelmanagementsystem.entity.Booking;
import edu.comp438.hotelmanagementsystem.entity.Room;
import edu.comp438.hotelmanagementsystem.repository.BookingRepository;
import edu.comp438.hotelmanagementsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingRoomMapper {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public BookingRoomMapper(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    public BookingRoomDTO toDto(BookingRoom bookingRoom) {
        return new BookingRoomDTO(
                bookingRoom.getId().getBookingId(),
                bookingRoom.getId().getRoomId()
        );
    }

    public BookingRoom toEntity(BookingRoomDTO bookingRoomDTO) {
        BookingRoomId bookingRoomId = new BookingRoomId(bookingRoomDTO.getBookingId(), bookingRoomDTO.getRoomId());
        Booking booking = bookingRepository.findById(bookingRoomDTO.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with given id : " + bookingRoomDTO.getBookingId()));
        Room room = roomRepository.findById(bookingRoomDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with given id : " + bookingRoomDTO.getRoomId()));

        BookingRoom bookingRoom = new BookingRoom();
        bookingRoom.setId(bookingRoomId);
        bookingRoom.setBooking(booking);
        bookingRoom.setRoom(room);
        return bookingRoom;
    }
}
