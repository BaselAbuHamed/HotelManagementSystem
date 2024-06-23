package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.RoomStatusDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomStatus;
import edu.comp438.hotelmanagementsystem.controller.RoomStatusController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RoomStatusModelAssembler implements RepresentationModelAssembler<RoomStatus, EntityModel<RoomStatusDTO> >{

    @Override
    @NonNull
    public EntityModel<RoomStatusDTO> toModel(@NonNull RoomStatus roomStatus) {
        RoomStatusDTO roomStatusDTO = new RoomStatusDTO(
                roomStatus.getId(),
                roomStatus.getStatusName()
        );

        EntityModel<RoomStatusDTO> roomStatusEntityModel = EntityModel.of(roomStatusDTO);
        roomStatusEntityModel.add(linkTo(methodOn(RoomStatusController.class).getRoomStatusById(roomStatus.getId())).withSelfRel());
        return roomStatusEntityModel;
    }
}
