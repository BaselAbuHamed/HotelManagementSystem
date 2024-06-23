package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.BookingDTO;
import edu.comp438.hotelmanagementsystem.dto.CheckinCheckoutDTO;
import edu.comp438.hotelmanagementsystem.entity.*;
import edu.comp438.hotelmanagementsystem.repository.*;
import edu.comp438.hotelmanagementsystem.service.BookingProcessService;
import edu.comp438.hotelmanagementsystem.mapper.BookingMapper;
import edu.comp438.hotelmanagementsystem.mapper.CheckinCheckoutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class BookingProcessServiceImpl implements BookingProcessService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    private final CheckinCheckoutRepository checkinCheckoutRepository;
    private final BookingRoomRepository bookingRoomRepository;
    private final BookingMapper bookingMapper;
    private final CheckinCheckoutMapper checkinCheckoutMapper;

    @Autowired
    public BookingProcessServiceImpl(BookingRepository bookingRepository, RoomRepository roomRepository,
                                     CustomerRepository customerRepository, CheckinCheckoutRepository checkinCheckoutRepository,
                                     BookingRoomRepository bookingRoomRepository, BookingMapper bookingMapper,
                                     CheckinCheckoutMapper checkinCheckoutMapper) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
        this.checkinCheckoutRepository = checkinCheckoutRepository;
        this.bookingRoomRepository = bookingRoomRepository;
        this.bookingMapper = bookingMapper;
        this.checkinCheckoutMapper = checkinCheckoutMapper;
    }

    @Override
    @Transactional
    public BookingDTO reserveRoom(BookingDTO bookingDTO) {
        // Create customer if not exists
        Customer customer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseGet(() -> {
                    Customer newCustomer = new Customer();
                    newCustomer.setId(bookingDTO.getCustomerId());
                    // Set other customer properties
                    return customerRepository.save(newCustomer);
                });

        // Create booking
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setCheckinDate(bookingDTO.getCheckinDate());
        booking.setCheckoutDate(bookingDTO.getCheckoutDate());
        booking.setNumAdults(bookingDTO.getNumAdults());
        booking.setNumChildren(bookingDTO.getNumChildren());
        booking.setBookingAmount(bookingDTO.getBookingAmount());
        booking = bookingRepository.save(booking);

        // Reserve rooms
        for (Long roomId : bookingDTO.getRoomIds()) {
            Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
            BookingRoom bookingRoom = new BookingRoom(new BookingRoomId(booking.getId(), room.getId()), booking, room);
            bookingRoomRepository.save(bookingRoom);
        }

        return bookingMapper.toDto(booking);
    }

    @Override
    @Transactional
    public CheckinCheckoutDTO checkin(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        CheckinCheckout checkinCheckout = new CheckinCheckout();
        checkinCheckout.setBooking(booking);
        checkinCheckout.setCheckinDate(LocalDate.now());
        checkinCheckout.setCheckedIn(true);
        checkinCheckout = checkinCheckoutRepository.save(checkinCheckout);

        return checkinCheckoutMapper.toDto(checkinCheckout);
    }

    @Override
    @Transactional
    public CheckinCheckoutDTO checkout(Long bookingId) {
        CheckinCheckout checkinCheckout = checkinCheckoutRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Checkin/Checkout not found"));
        checkinCheckout.setCheckoutDate(LocalDate.now());
        checkinCheckout.setCheckedOut(true);
        checkinCheckout = checkinCheckoutRepository.save(checkinCheckout);

        return checkinCheckoutMapper.toDto(checkinCheckout);
    }

    @Override
    @Transactional
    public void cancelReservation(Long bookingId) {
        bookingRoomRepository.deleteAll(bookingRoomRepository.findByBookingId(bookingId));
        bookingRepository.deleteById(bookingId);
    }
}
