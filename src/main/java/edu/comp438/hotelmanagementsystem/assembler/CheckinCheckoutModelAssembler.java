package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.CheckinCheckoutDTO;
import edu.comp438.hotelmanagementsystem.entity.CheckinCheckout;
import edu.comp438.hotelmanagementsystem.controller.CheckinCheckoutController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CheckinCheckoutModelAssembler implements RepresentationModelAssembler<CheckinCheckout, CheckinCheckoutDTO> {

    @Override
    @NonNull
    public CheckinCheckoutDTO toModel(@NonNull CheckinCheckout checkinCheckout) {
        CheckinCheckoutDTO checkinCheckoutDTO = new CheckinCheckoutDTO(
                checkinCheckout.getId(),
                null, // Handle booking separately
                checkinCheckout.getCheckinDate(),
                checkinCheckout.getCheckoutDate(),
                checkinCheckout.getCheckedIn(),
                checkinCheckout.getCheckedOut()
        );

        checkinCheckoutDTO.add(linkTo(methodOn(CheckinCheckoutController.class).getCheckinCheckoutById(checkinCheckout.getId())).withSelfRel());
        return checkinCheckoutDTO;
    }
}
