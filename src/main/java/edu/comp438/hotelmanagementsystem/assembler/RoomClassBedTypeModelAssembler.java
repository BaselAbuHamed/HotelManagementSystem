package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.RoomClassBedTypeDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClassBedType;
import edu.comp438.hotelmanagementsystem.controller.RoomClassBedTypeController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RoomClassBedTypeModelAssembler implements RepresentationModelAssembler<RoomClassBedType, RoomClassBedTypeDTO> {

    @Override
    @NonNull
    public RoomClassBedTypeDTO toModel(@NonNull RoomClassBedType roomClassBedType) {
        RoomClassBedTypeDTO roomClassBedTypeDTO = new RoomClassBedTypeDTO(
                roomClassBedType.getRoomClass().getId(),
                roomClassBedType.getBedType().getId(),
                roomClassBedType.getNumBeds()
        );

        roomClassBedTypeDTO.add(linkTo(methodOn(RoomClassBedTypeController.class).getRoomClassBedTypeById(
                roomClassBedType.getRoomClass().getId(),
                roomClassBedType.getBedType().getId())).withSelfRel());
        return roomClassBedTypeDTO;
    }
}
