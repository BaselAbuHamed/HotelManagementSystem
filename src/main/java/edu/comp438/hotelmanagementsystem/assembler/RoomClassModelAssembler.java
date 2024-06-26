package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.RoomClassDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClass;
import edu.comp438.hotelmanagementsystem.controller.RoomClassController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RoomClassModelAssembler implements RepresentationModelAssembler<RoomClass, EntityModel<RoomClassDTO> >{

    @Override
    @NonNull
    public EntityModel<RoomClassDTO> toModel(@NonNull RoomClass roomClass) {
        RoomClassDTO roomClassDTO = new RoomClassDTO(
                roomClass.getId(),
                roomClass.getClassName(),
                roomClass.getBasePrice()
        );

        EntityModel<RoomClassDTO> roomClassEntityModel = EntityModel.of(roomClassDTO);
        roomClassEntityModel.add(linkTo(methodOn(RoomClassController.class).getRoomClassById(roomClass.getId())).withSelfRel());
        return roomClassEntityModel;
    }
}
