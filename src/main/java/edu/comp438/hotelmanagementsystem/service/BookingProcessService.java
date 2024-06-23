package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.BookingDTO;
import edu.comp438.hotelmanagementsystem.dto.CheckinCheckoutDTO;
import org.springframework.transaction.annotation.Transactional;

public interface BookingProcessService {

    @Transactional
    BookingDTO reserveRoom(BookingDTO bookingDTO);

    @Transactional
    CheckinCheckoutDTO checkin(Long bookingId);

    @Transactional
    CheckinCheckoutDTO checkout(Long bookingId);

    @Transactional
    void cancelReservation(Long bookingId);
}
