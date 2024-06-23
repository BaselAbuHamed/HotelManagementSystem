package edu.comp438.hotelmanagementsystem.repository;

import edu.comp438.hotelmanagementsystem.entity.CheckinCheckout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckinCheckoutRepository extends JpaRepository<CheckinCheckout, Long>{
    Optional<CheckinCheckout> findByBookingId(Long bookingId);

}
