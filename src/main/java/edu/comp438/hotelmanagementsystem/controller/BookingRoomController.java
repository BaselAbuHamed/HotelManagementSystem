package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.BookingRoomDTO;
import edu.comp438.hotelmanagementsystem.service.BookingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookingrooms")
public class BookingRoomController {

    private final BookingRoomService bookingRoomService;

    @Autowired
    public BookingRoomController(BookingRoomService bookingRoomService) {
        this.bookingRoomService = bookingRoomService;
    }

    @PostMapping
    public ResponseEntity<BookingRoomDTO> createBookingRoom(@RequestBody BookingRoomDTO bookingRoomDTO) {
        BookingRoomDTO createdBookingRoom = bookingRoomService.createBookingRoom(bookingRoomDTO);
        return ResponseEntity.ok(createdBookingRoom);
    }

    @PutMapping("/{bookingId}/{roomId}")
    public ResponseEntity<BookingRoomDTO> updateBookingRoom(@PathVariable Long bookingId, @PathVariable Long roomId, @RequestBody BookingRoomDTO bookingRoomDTO) {
        BookingRoomDTO updatedBookingRoom = bookingRoomService.updateBookingRoom(bookingId, roomId, bookingRoomDTO);
        return ResponseEntity.ok(updatedBookingRoom);
    }

    @GetMapping("/{bookingId}/{roomId}")
    public ResponseEntity<BookingRoomDTO> getBookingRoomById(@PathVariable Long bookingId, @PathVariable Long roomId) {
        BookingRoomDTO bookingRoomDTO = bookingRoomService.getBookingRoomById(bookingId, roomId);
        return ResponseEntity.ok(bookingRoomDTO);
    }

    @DeleteMapping("/{bookingId}/{roomId}")
    public ResponseEntity<Void> deleteBookingRoom(@PathVariable Long bookingId, @PathVariable Long roomId) {
        bookingRoomService.deleteBookingRoom(bookingId, roomId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BookingRoomDTO>> getAllBookingRooms() {
        List<BookingRoomDTO> bookingRooms = bookingRoomService.getAllBookingRooms();
        return ResponseEntity.ok(bookingRooms);
    }
}
