package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.CheckinCheckoutDTO;
import edu.comp438.hotelmanagementsystem.entity.Booking;
import edu.comp438.hotelmanagementsystem.entity.CheckinCheckout;
import edu.comp438.hotelmanagementsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckinCheckoutMapper {

    private final BookingRepository bookingRepository;

    @Autowired
    public CheckinCheckoutMapper(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public CheckinCheckoutDTO toDto(CheckinCheckout checkinCheckout) {
        return new CheckinCheckoutDTO(
                checkinCheckout.getId(),
                checkinCheckout.getBooking().getId(),
                checkinCheckout.getCheckinDate(),
                checkinCheckout.getCheckoutDate(),
                checkinCheckout.getCheckedIn(),
                checkinCheckout.getCheckedOut()
        );
    }

    public CheckinCheckout toEntity(CheckinCheckoutDTO checkinCheckoutDTO) {
        CheckinCheckout checkinCheckout = new CheckinCheckout();
        checkinCheckout.setId(checkinCheckoutDTO.getId());

        Booking booking = bookingRepository.findById(checkinCheckoutDTO.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + checkinCheckoutDTO.getBookingId()));
        checkinCheckout.setBooking(booking);

        checkinCheckout.setCheckinDate(checkinCheckoutDTO.getCheckinDate());
        checkinCheckout.setCheckoutDate(checkinCheckoutDTO.getCheckoutDate());
        checkinCheckout.setCheckedIn(checkinCheckoutDTO.getCheckedIn());
        checkinCheckout.setCheckedOut(checkinCheckoutDTO.getCheckedOut());

        return checkinCheckout;
    }
}
