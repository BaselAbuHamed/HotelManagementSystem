package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.BookingDTO;
import edu.comp438.hotelmanagementsystem.entity.Booking;
import edu.comp438.hotelmanagementsystem.controller.BookingController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BookingModelAssembler implements RepresentationModelAssembler<Booking, EntityModel<BookingDTO> >{

    @Override
    @NonNull
    public EntityModel<BookingDTO> toModel(@NonNull Booking booking) {

        List<Long> roomIds = booking.getBookingRooms().stream()
                .map(bookingRoom -> bookingRoom.getRoom().getId())
                .collect(Collectors.toList());


        BookingDTO bookingDTO = new BookingDTO(
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
        EntityModel<BookingDTO> bookingModel = EntityModel.of(bookingDTO);
        bookingModel.add(linkTo(methodOn(BookingController.class).getBookingById(booking.getId())).withSelfRel());
        return bookingModel;
    }
}
