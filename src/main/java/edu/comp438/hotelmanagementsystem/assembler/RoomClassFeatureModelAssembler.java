package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.RoomClassFeatureDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClassFeature;
import edu.comp438.hotelmanagementsystem.controller.RoomClassFeatureController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RoomClassFeatureModelAssembler implements RepresentationModelAssembler<RoomClassFeature, RoomClassFeatureDTO> {

    @Override
    @NonNull
    public RoomClassFeatureDTO toModel(@NonNull RoomClassFeature roomClassFeature) {
        RoomClassFeatureDTO roomClassFeatureDTO = new RoomClassFeatureDTO(
                roomClassFeature.getRoomClass().getId(),
                roomClassFeature.getFeature().getId()
        );

        roomClassFeatureDTO.add(linkTo(methodOn(RoomClassFeatureController.class).getRoomClassFeatureById(
                roomClassFeature.getRoomClass().getId(),
                roomClassFeature.getFeature().getId())).withSelfRel());
        return roomClassFeatureDTO;
    }
}
