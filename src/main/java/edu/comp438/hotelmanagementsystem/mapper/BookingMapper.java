package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.BookingDTO;
import edu.comp438.hotelmanagementsystem.entity.Booking;
import edu.comp438.hotelmanagementsystem.entity.Customer;
import edu.comp438.hotelmanagementsystem.entity.PaymentStatus;
import edu.comp438.hotelmanagementsystem.repository.CustomerRepository;
import edu.comp438.hotelmanagementsystem.repository.PaymentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    private final CustomerRepository customerRepository;
    private final PaymentStatusRepository paymentStatusRepository;

    @Autowired
    public BookingMapper(CustomerRepository customerRepository, PaymentStatusRepository paymentStatusRepository) {
        this.customerRepository = customerRepository;
        this.paymentStatusRepository = paymentStatusRepository;
    }

    public BookingDTO toDto(Booking booking) {
        return new BookingDTO(
                booking.getId(),
                booking.getCustomer().getId(),
                booking.getCheckinDate(),
                booking.getCheckoutDate(),
                booking.getNumAdults(),
                booking.getNumChildren(),
                booking.getBookingAmount(),
                booking.getPaymentStatus().getId()
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

        return booking;
    }
}
