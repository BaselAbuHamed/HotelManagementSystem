package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.FeatureDTO;
import java.util.List;

public interface FeatureService {
    FeatureDTO createFeature(FeatureDTO featureDTO);
    FeatureDTO updateFeature(Long id, FeatureDTO featureDTO);
    FeatureDTO getFeatureById(Long id);
    void deleteFeature(Long id);
    List<FeatureDTO> getAllFeatures();
}
