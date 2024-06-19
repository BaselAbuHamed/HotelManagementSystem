package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.FeatureDTO;
import edu.comp438.hotelmanagementsystem.entity.Feature;
import org.springframework.stereotype.Component;

@Component
public class FeatureMapper {

    public FeatureDTO toDto(Feature feature) {
        return new FeatureDTO(
                feature.getId(),
                feature.getFeatureName()
        );
    }

    public Feature toEntity(FeatureDTO featureDTO) {
        Feature feature = new Feature();
        feature.setId(featureDTO.getId());
        feature.setFeatureName(featureDTO.getFeatureName());
        return feature;
    }
}
