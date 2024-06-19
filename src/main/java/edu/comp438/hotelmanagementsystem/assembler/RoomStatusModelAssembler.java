package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.RoomStatusDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomStatus;
import edu.comp438.hotelmanagementsystem.controller.RoomStatusController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RoomStatusModelAssembler implements RepresentationModelAssembler<RoomStatus, RoomStatusDTO> {

    @Override
    @NonNull
    public RoomStatusDTO toModel(@NonNull RoomStatus roomStatus) {
        RoomStatusDTO roomStatusDTO = new RoomStatusDTO(
                roomStatus.getId(),
                roomStatus.getStatusName()
        );

        roomStatusDTO.add(linkTo(methodOn(RoomStatusController.class).getRoomStatusById(roomStatus.getId())).withSelfRel());
        return roomStatusDTO;
    }
}
