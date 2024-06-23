package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.RoomDTO;
import edu.comp438.hotelmanagementsystem.entity.Room;
import edu.comp438.hotelmanagementsystem.controller.RoomController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RoomModelAssembler implements RepresentationModelAssembler<Room, EntityModel<RoomDTO> >{

    @Override
    @NonNull
    public EntityModel<RoomDTO> toModel(@NonNull Room room) {
        RoomDTO roomDTO = new RoomDTO(
                room.getId(),
                room.getFloor().getId(),
                room.getRoomClass().getId(),
                room.getStatus().getId(),
                room.getRoomNumber()
        );

        EntityModel<RoomDTO> roomEntityModel = EntityModel.of(roomDTO);
        roomEntityModel.add(linkTo(methodOn(RoomController.class).getRoomById(room.getId())).withSelfRel());
        return roomEntityModel;
    }
}
