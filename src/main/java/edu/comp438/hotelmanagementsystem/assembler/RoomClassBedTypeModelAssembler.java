package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.RoomClassBedTypeDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClassBedType;
import edu.comp438.hotelmanagementsystem.controller.RoomClassBedTypeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RoomClassBedTypeModelAssembler implements RepresentationModelAssembler<RoomClassBedType, EntityModel<RoomClassBedTypeDTO>> {

    @Override
    @NonNull
    public EntityModel<RoomClassBedTypeDTO> toModel(@NonNull RoomClassBedType roomClassBedType) {
        RoomClassBedTypeDTO roomClassBedTypeDTO = new RoomClassBedTypeDTO(
                roomClassBedType.getRoomClass().getId(),
                roomClassBedType.getBedType().getId(),
                roomClassBedType.getNumBeds()
        );

        EntityModel<RoomClassBedTypeDTO> roomClassBedTypeEntityModel = EntityModel.of(roomClassBedTypeDTO);
        roomClassBedTypeEntityModel.add(linkTo(methodOn(RoomClassBedTypeController.class).getRoomClassBedTypeById(
                roomClassBedType.getRoomClass().getId(),
                roomClassBedType.getBedType().getId())).withSelfRel());
        return roomClassBedTypeEntityModel;
    }
}
