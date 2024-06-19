package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.BookingAddonDTO;
import edu.comp438.hotelmanagementsystem.entity.Addon;
import edu.comp438.hotelmanagementsystem.entity.Booking;
import edu.comp438.hotelmanagementsystem.entity.BookingAddon;
import edu.comp438.hotelmanagementsystem.entity.BookingAddonId;
import edu.comp438.hotelmanagementsystem.repository.AddonRepository;
import edu.comp438.hotelmanagementsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingAddonMapper {

    private final BookingRepository bookingRepository;
    private final AddonRepository addonRepository;

    @Autowired
    public BookingAddonMapper(BookingRepository bookingRepository, AddonRepository addonRepository) {
        this.bookingRepository = bookingRepository;
        this.addonRepository = addonRepository;
    }

    public BookingAddonDTO toDto(BookingAddon bookingAddon) {
        return new BookingAddonDTO(
                bookingAddon.getId().getBookingId(),
                bookingAddon.getId().getAddonId()
        );
    }

    public BookingAddon toEntity(BookingAddonDTO bookingAddonDTO) {
        BookingAddonId bookingAddonId = new BookingAddonId(bookingAddonDTO.getBookingId(), bookingAddonDTO.getAddonId());
        Booking booking = bookingRepository.findById(bookingAddonDTO.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with given id : " + bookingAddonDTO.getBookingId()));
        Addon addon = addonRepository.findById(bookingAddonDTO.getAddonId())
                .orElseThrow(() -> new RuntimeException("Addon not found with given id : " + bookingAddonDTO.getAddonId()));

        BookingAddon bookingAddon = new BookingAddon();
        bookingAddon.setId(bookingAddonId);
        bookingAddon.setBooking(booking);
        bookingAddon.setAddon(addon);
        return bookingAddon;
    }
}
