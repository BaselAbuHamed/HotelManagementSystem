package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.BookingAddonDTO;
import edu.comp438.hotelmanagementsystem.entity.BookingAddon;
import edu.comp438.hotelmanagementsystem.entity.BookingAddonId;
import edu.comp438.hotelmanagementsystem.mapper.BookingAddonMapper;
import edu.comp438.hotelmanagementsystem.repository.BookingAddonRepository;
import edu.comp438.hotelmanagementsystem.service.BookingAddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingAddonServiceImpl implements BookingAddonService {

    private final BookingAddonRepository bookingAddonRepository;
    private final BookingAddonMapper bookingAddonMapper;

    @Autowired
    public BookingAddonServiceImpl(BookingAddonRepository bookingAddonRepository, BookingAddonMapper bookingAddonMapper) {
        this.bookingAddonRepository = bookingAddonRepository;
        this.bookingAddonMapper = bookingAddonMapper;
    }

    @Override
    public BookingAddonDTO createBookingAddon(BookingAddonDTO bookingAddonDTO) {
        BookingAddon bookingAddon = bookingAddonMapper.toEntity(bookingAddonDTO);
        BookingAddon savedBookingAddon = bookingAddonRepository.save(bookingAddon);
        return bookingAddonMapper.toDto(savedBookingAddon);
    }

    @Override
    public BookingAddonDTO updateBookingAddon(Long bookingId, BookingAddonDTO bookingAddonDTO) {
        BookingAddonId id = new BookingAddonId(bookingId, bookingAddonDTO.getAddonId());
        BookingAddon existingBookingAddon = bookingAddonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingAddon not found"));
        existingBookingAddon.setAddon(bookingAddonMapper.toEntity(bookingAddonDTO).getAddon());
        BookingAddon updatedBookingAddon = bookingAddonRepository.save(existingBookingAddon);
        return bookingAddonMapper.toDto(updatedBookingAddon);
    }

    @Override
    public BookingAddonDTO getBookingAddonById(Long bookingId, Long addonId) {
        BookingAddonId id = new BookingAddonId(bookingId, addonId);
        BookingAddon bookingAddon = bookingAddonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingAddon not found"));
        return bookingAddonMapper.toDto(bookingAddon);
    }

    @Override
    public void deleteBookingAddon(Long bookingId, Long addonId) {
        BookingAddonId id = new BookingAddonId(bookingId, addonId);
        bookingAddonRepository.deleteById(id);
    }

    @Override
    public List<BookingAddonDTO> getAllBookingAddons() {
        return bookingAddonRepository.findAll().stream()
                .map(bookingAddonMapper::toDto)
                .collect(Collectors.toList());
    }
}
