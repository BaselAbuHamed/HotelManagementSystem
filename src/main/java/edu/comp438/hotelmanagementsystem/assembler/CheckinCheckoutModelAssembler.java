package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.CheckinCheckoutDTO;
import edu.comp438.hotelmanagementsystem.dto.BookingDTO;
import edu.comp438.hotelmanagementsystem.entity.CheckinCheckout;
import edu.comp438.hotelmanagementsystem.controller.CheckinCheckoutController;
import edu.comp438.hotelmanagementsystem.mapper.BookingMapper;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CheckinCheckoutModelAssembler implements RepresentationModelAssembler<CheckinCheckout, CheckinCheckoutDTO> {

    private final BookingMapper bookingMapper;

    public CheckinCheckoutModelAssembler(BookingMapper bookingMapper) {
        this.bookingMapper = bookingMapper;
    }

    @Override
    @NonNull
    public CheckinCheckoutDTO toModel(@NonNull CheckinCheckout checkinCheckout) {
        BookingDTO bookingDTO = bookingMapper.toDto(checkinCheckout.getBooking());
        CheckinCheckoutDTO checkinCheckoutDTO = new CheckinCheckoutDTO(
                checkinCheckout.getId(),
                checkinCheckout.getBooking().getId(),
                checkinCheckout.getCheckinDate(),
                checkinCheckout.getCheckoutDate(),
                checkinCheckout.getCheckedIn(),
                checkinCheckout.getCheckedOut()
        );

        checkinCheckoutDTO.add(linkTo(methodOn(CheckinCheckoutController.class).getCheckinCheckoutById(checkinCheckout.getId())).withSelfRel());
        return checkinCheckoutDTO;
    }
}
