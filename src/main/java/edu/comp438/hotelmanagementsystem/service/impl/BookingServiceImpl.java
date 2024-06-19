package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.BookingDTO;
import edu.comp438.hotelmanagementsystem.entity.Booking;
import edu.comp438.hotelmanagementsystem.mapper.BookingMapper;
import edu.comp438.hotelmanagementsystem.repository.BookingRepository;
import edu.comp438.hotelmanagementsystem.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        Booking savedBooking = bookingRepository.save(booking);
        return bookingMapper.toDto(savedBooking);
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Update existingBooking properties with bookingDTO data
        existingBooking.setCustomer(bookingMapper.toEntity(bookingDTO).getCustomer());
        existingBooking.setCheckinDate(bookingDTO.getCheckinDate());
        existingBooking.setCheckoutDate(bookingDTO.getCheckoutDate());
        existingBooking.setNumAdults(bookingDTO.getNumAdults());
        existingBooking.setNumChildren(bookingDTO.getNumChildren());
        existingBooking.setBookingAmount(bookingDTO.getBookingAmount());
        existingBooking.setPaymentStatus(bookingMapper.toEntity(bookingDTO).getPaymentStatus());

        Booking updatedBooking = bookingRepository.save(existingBooking);
        return bookingMapper.toDto(updatedBooking);
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return bookingMapper.toDto(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }
}
