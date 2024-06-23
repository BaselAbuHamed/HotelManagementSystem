package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.FloorDTO;
import edu.comp438.hotelmanagementsystem.entity.Floor;
import edu.comp438.hotelmanagementsystem.controller.FloorController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class FloorModelAssembler implements RepresentationModelAssembler<Floor, EntityModel<FloorDTO> > {

    @Override
    @NonNull
    public EntityModel<FloorDTO> toModel(@NonNull Floor floor) {
        FloorDTO floorDTO = new FloorDTO(
                floor.getId(),
                floor.getFloorNumber()
        );

        EntityModel<FloorDTO> floorEntityModel = EntityModel.of(floorDTO);
        floorEntityModel.add(linkTo(methodOn(FloorController.class).getFloorById(floor.getId())).withSelfRel());
        return floorEntityModel;
    }
}
