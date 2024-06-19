package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.BookingAddonDTO;

import java.util.List;

public interface BookingAddonService {
    BookingAddonDTO createBookingAddon(BookingAddonDTO bookingAddonDTO);
    BookingAddonDTO updateBookingAddon(Long bookingId, BookingAddonDTO bookingAddonDTO);
    BookingAddonDTO getBookingAddonById(Long bookingId, Long addonId);
    void deleteBookingAddon(Long bookingId, Long addonId);
    List<BookingAddonDTO> getAllBookingAddons();
}
