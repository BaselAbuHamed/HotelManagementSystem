package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.AddonDTO;
import edu.comp438.hotelmanagementsystem.entity.Addon;
import edu.comp438.hotelmanagementsystem.controller.AddonController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AddonModelAssembler implements RepresentationModelAssembler<Addon, EntityModel<AddonDTO>> {

    @Override
    @NonNull
    public EntityModel<AddonDTO> toModel(@NonNull Addon addon) {
        AddonDTO addonDTO = new AddonDTO(
                addon.getId(),
                addon.getAddonName(),
                addon.getPrice()
        );
        EntityModel <AddonDTO> addonEntityModel = EntityModel.of(addonDTO);
        addonEntityModel.add(linkTo(methodOn(AddonController.class).getAddonById(addon.getId())).withSelfRel());
        return addonEntityModel;
    }
}
