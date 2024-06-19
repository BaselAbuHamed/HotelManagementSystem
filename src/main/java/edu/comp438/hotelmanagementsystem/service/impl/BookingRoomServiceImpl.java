package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.BookingRoomDTO;
import edu.comp438.hotelmanagementsystem.entity.BookingRoom;
import edu.comp438.hotelmanagementsystem.entity.BookingRoomId;
import edu.comp438.hotelmanagementsystem.mapper.BookingRoomMapper;
import edu.comp438.hotelmanagementsystem.repository.BookingRoomRepository;
import edu.comp438.hotelmanagementsystem.service.BookingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingRoomServiceImpl implements BookingRoomService {

    private final BookingRoomRepository bookingRoomRepository;
    private final BookingRoomMapper bookingRoomMapper;

    @Autowired
    public BookingRoomServiceImpl(BookingRoomRepository bookingRoomRepository, BookingRoomMapper bookingRoomMapper) {
        this.bookingRoomRepository = bookingRoomRepository;
        this.bookingRoomMapper = bookingRoomMapper;
    }

    @Override
    public BookingRoomDTO createBookingRoom(BookingRoomDTO bookingRoomDTO) {
        BookingRoom bookingRoom = bookingRoomMapper.toEntity(bookingRoomDTO);
        BookingRoom savedBookingRoom = bookingRoomRepository.save(bookingRoom);
        return bookingRoomMapper.toDto(savedBookingRoom);
    }

    @Override
    public BookingRoomDTO updateBookingRoom(Long bookingId, Long roomId, BookingRoomDTO bookingRoomDTO) {
        BookingRoomId id = new BookingRoomId(bookingId, roomId);
        BookingRoom existingBookingRoom = bookingRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingRoom not found"));
        // Update fields as needed
        BookingRoom updatedBookingRoom = bookingRoomRepository.save(existingBookingRoom);
        return bookingRoomMapper.toDto(updatedBookingRoom);
    }

    @Override
    public BookingRoomDTO getBookingRoomById(Long bookingId, Long roomId) {
        BookingRoomId id = new BookingRoomId(bookingId, roomId);
        BookingRoom bookingRoom = bookingRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingRoom not found"));
        return bookingRoomMapper.toDto(bookingRoom);
    }

    @Override
    public void deleteBookingRoom(Long bookingId, Long roomId) {
        BookingRoomId id = new BookingRoomId(bookingId, roomId);
        bookingRoomRepository.deleteById(id);
    }

    @Override
    public List<BookingRoomDTO> getAllBookingRooms() {
        return bookingRoomRepository.findAll().stream()
                .map(bookingRoomMapper::toDto)
                .collect(Collectors.toList());
    }
}
