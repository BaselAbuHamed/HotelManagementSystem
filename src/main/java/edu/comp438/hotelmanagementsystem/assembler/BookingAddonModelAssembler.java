package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.BookingAddonDTO;
import edu.comp438.hotelmanagementsystem.entity.BookingAddon;
import edu.comp438.hotelmanagementsystem.entity.BookingAddonId;
import edu.comp438.hotelmanagementsystem.controller.BookingAddonController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BookingAddonModelAssembler implements RepresentationModelAssembler<BookingAddon, BookingAddonDTO> {

    @Override
    @NonNull
    public BookingAddonDTO toModel(@NonNull BookingAddon bookingAddon) {
        BookingAddonId id = bookingAddon.getId();
        BookingAddonDTO bookingAddonDTO = new BookingAddonDTO(
                id.getBookingId(),
                id.getAddonId()
        );

        bookingAddonDTO.add(linkTo(methodOn(BookingAddonController.class).getBookingAddonById(id.getBookingId(), id.getAddonId())).withSelfRel());
        return bookingAddonDTO;
    }
}
