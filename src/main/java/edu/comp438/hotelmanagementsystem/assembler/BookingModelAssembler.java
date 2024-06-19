package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.BookingDTO;
import edu.comp438.hotelmanagementsystem.entity.Booking;
import edu.comp438.hotelmanagementsystem.controller.BookingController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BookingModelAssembler implements RepresentationModelAssembler<Booking, BookingDTO> {

    @Override
    @NonNull
    public BookingDTO toModel(@NonNull Booking booking) {
        BookingDTO bookingDTO = new BookingDTO(
                booking.getId(),
                booking.getCustomer().getId(),
                booking.getCheckinDate(),
                booking.getCheckoutDate(),
                booking.getNumAdults(),
                booking.getNumChildren(),
                booking.getBookingAmount(),
                booking.getPaymentStatus().getId()
        );

        bookingDTO.add(linkTo(methodOn(BookingController.class).getBookingById(booking.getId())).withSelfRel());
        return bookingDTO;
    }
}
