package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.BookingAddonDTO;
import edu.comp438.hotelmanagementsystem.service.BookingAddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookingaddons")
public class BookingAddonController {

    private final BookingAddonService bookingAddonService;

    @Autowired
    public BookingAddonController(BookingAddonService bookingAddonService) {
        this.bookingAddonService = bookingAddonService;
    }

    @PostMapping
    public ResponseEntity<BookingAddonDTO> createBookingAddon(@RequestBody BookingAddonDTO bookingAddonDTO) {
        BookingAddonDTO createdBookingAddon = bookingAddonService.createBookingAddon(bookingAddonDTO);
        return ResponseEntity.ok(createdBookingAddon);
    }

    @PutMapping("/{bookingId}/{addonId}")
    public ResponseEntity<BookingAddonDTO> updateBookingAddon(@PathVariable Long bookingId, @PathVariable Long addonId, @RequestBody BookingAddonDTO bookingAddonDTO) {
        bookingAddonDTO.setAddonId(addonId);
        BookingAddonDTO updatedBookingAddon = bookingAddonService.updateBookingAddon(bookingId, bookingAddonDTO);
        return ResponseEntity.ok(updatedBookingAddon);
    }

    @GetMapping("/{bookingId}/{addonId}")
    public ResponseEntity<BookingAddonDTO> getBookingAddonById(@PathVariable Long bookingId, @PathVariable Long addonId) {
        BookingAddonDTO bookingAddonDTO = bookingAddonService.getBookingAddonById(bookingId, addonId);
        return ResponseEntity.ok(bookingAddonDTO);
    }

    @DeleteMapping("/{bookingId}/{addonId}")
    public ResponseEntity<Void> deleteBookingAddon(@PathVariable Long bookingId, @PathVariable Long addonId) {
        bookingAddonService.deleteBookingAddon(bookingId, addonId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BookingAddonDTO>> getAllBookingAddons() {
        List<BookingAddonDTO> bookingAddons = bookingAddonService.getAllBookingAddons();
        return ResponseEntity.ok(bookingAddons);
    }
}
