package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.BookingRoomDTO;
import edu.comp438.hotelmanagementsystem.entity.BookingRoom;
import edu.comp438.hotelmanagementsystem.controller.BookingRoomController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BookingRoomModelAssembler implements RepresentationModelAssembler<BookingRoom, EntityModel<BookingRoomDTO>> {

    @Override
    @NonNull
    public  EntityModel<BookingRoomDTO> toModel(@NonNull BookingRoom bookingRoom) {
        BookingRoomDTO bookingRoomDTO = new BookingRoomDTO(
                bookingRoom.getId().getBookingId(),
                bookingRoom.getId().getRoomId()
        );

        EntityModel<BookingRoomDTO> bookingRoomEntityModel = EntityModel.of(bookingRoomDTO);
        bookingRoomEntityModel.add(linkTo(methodOn(BookingRoomController.class).getBookingRoomById(bookingRoom.getId().getBookingId(), bookingRoom.getId().getRoomId())).withSelfRel());
        return bookingRoomEntityModel;
    }
}
