package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.FeatureDTO;
import edu.comp438.hotelmanagementsystem.entity.Feature;
import edu.comp438.hotelmanagementsystem.controller.FeatureController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class FeatureModelAssembler implements RepresentationModelAssembler<Feature, FeatureDTO> {

    @Override
    @NonNull
    public FeatureDTO toModel(@NonNull Feature feature) {
        FeatureDTO featureDTO = new FeatureDTO(
                feature.getId(),
                feature.getFeatureName()
        );

        featureDTO.add(linkTo(methodOn(FeatureController.class).getFeatureById(feature.getId())).withSelfRel());
        return featureDTO;
    }
}
