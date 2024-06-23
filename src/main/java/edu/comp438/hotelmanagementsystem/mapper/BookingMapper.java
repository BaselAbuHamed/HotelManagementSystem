package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.BookingDTO;
import edu.comp438.hotelmanagementsystem.entity.*;
import edu.comp438.hotelmanagementsystem.repository.CustomerRepository;
import edu.comp438.hotelmanagementsystem.repository.PaymentStatusRepository;
import edu.comp438.hotelmanagementsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

    private final CustomerRepository customerRepository;
    private final PaymentStatusRepository paymentStatusRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public BookingMapper(CustomerRepository customerRepository, PaymentStatusRepository paymentStatusRepository, RoomRepository roomRepository) {
        this.customerRepository = customerRepository;
        this.paymentStatusRepository = paymentStatusRepository;
        this.roomRepository = roomRepository;
    }

    public BookingDTO toDto(Booking booking) {

        List<Long> roomIds = booking.getBookingRooms().stream()
                .map(bookingRoom -> bookingRoom.getRoom().getId())
                .collect(Collectors.toList());

        return new BookingDTO(
                booking.getId(),
                booking.getCustomer().getId(),
                booking.getCheckinDate(),
                booking.getCheckoutDate(),
                booking.getNumAdults(),
                booking.getNumChildren(),
                booking.getBookingAmount(),
                booking.getPaymentStatus().getId(),
                roomIds
        );
    }

    public Booking toEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());

        Customer customer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + bookingDTO.getCustomerId()));
        booking.setCustomer(customer);

        booking.setCheckinDate(bookingDTO.getCheckinDate());
        booking.setCheckoutDate(bookingDTO.getCheckoutDate());
        booking.setNumAdults(bookingDTO.getNumAdults());
        booking.setNumChildren(bookingDTO.getNumChildren());
        booking.setBookingAmount(bookingDTO.getBookingAmount());

        PaymentStatus paymentStatus = paymentStatusRepository.findById(bookingDTO.getPaymentStatusId())
                .orElseThrow(() -> new RuntimeException("Payment status not found with id: " + bookingDTO.getPaymentStatusId()));
        booking.setPaymentStatus(paymentStatus);

        List<Room> rooms = bookingDTO.getRoomIds().stream()
                .map(roomId -> roomRepository.findById(roomId)
                        .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId)))
                .toList();

        booking.setBookingRooms(rooms.stream()
                .map(room -> new BookingRoom(new BookingRoomId(booking.getId(), room.getId()), booking, room))
                .collect(Collectors.toSet()));

        return booking;
    }
}
