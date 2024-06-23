package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.BookingDTO;
import edu.comp438.hotelmanagementsystem.dto.CheckinCheckoutDTO;
import edu.comp438.hotelmanagementsystem.service.BookingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingProcessController {

    private final BookingProcessService bookingProcessService;

    @Autowired
    public BookingProcessController(BookingProcessService bookingProcessService) {
        this.bookingProcessService = bookingProcessService;
    }

    @PostMapping("/reserve")
    public ResponseEntity<BookingDTO> reserveRoom(@RequestBody BookingDTO bookingDTO) {
        BookingDTO reservedBooking = bookingProcessService.reserveRoom(bookingDTO);
        return ResponseEntity.ok(reservedBooking);
    }

    @PostMapping("/checkin/{bookingId}")
    public ResponseEntity<CheckinCheckoutDTO> checkin(@PathVariable Long bookingId) {
        CheckinCheckoutDTO checkinCheckoutDTO = bookingProcessService.checkin(bookingId);
        return ResponseEntity.ok(checkinCheckoutDTO);
    }

    @PostMapping("/checkout/{bookingId}")
    public ResponseEntity<CheckinCheckoutDTO> checkout(@PathVariable Long bookingId) {
        CheckinCheckoutDTO checkinCheckoutDTO = bookingProcessService.checkout(bookingId);
        return ResponseEntity.ok(checkinCheckoutDTO);
    }

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long bookingId) {
        bookingProcessService.cancelReservation(bookingId);
        return ResponseEntity.noContent().build();
    }
}
