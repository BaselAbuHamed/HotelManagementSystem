package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.BedTypeDTO;
import edu.comp438.hotelmanagementsystem.entity.BedType;
import edu.comp438.hotelmanagementsystem.controller.BedTypeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BedTypeModelAssembler implements RepresentationModelAssembler<BedType, EntityModel<BedTypeDTO>> {

    @Override
    @NonNull
    public EntityModel<BedTypeDTO> toModel(@NonNull BedType bedType) {
        BedTypeDTO bedTypeDTO = new BedTypeDTO(
                bedType.getId(),
                bedType.getBedTypeName()
        );
        EntityModel <BedTypeDTO> bedTypeEntityModel = EntityModel.of(bedTypeDTO);
        bedTypeEntityModel.add(linkTo(methodOn(BedTypeController.class).getBedTypeById(bedType.getId())).withSelfRel());
        return bedTypeEntityModel;
    }
}
