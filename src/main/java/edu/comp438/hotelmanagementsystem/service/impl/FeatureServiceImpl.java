package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.FeatureDTO;
import edu.comp438.hotelmanagementsystem.entity.Feature;
import edu.comp438.hotelmanagementsystem.mapper.FeatureMapper;
import edu.comp438.hotelmanagementsystem.repository.FeatureRepository;
import edu.comp438.hotelmanagementsystem.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    private final FeatureMapper featureMapper;

    public FeatureServiceImpl(FeatureRepository featureRepository, FeatureMapper featureMapper) {
        this.featureRepository = featureRepository;
        this.featureMapper = featureMapper;
    }

    @Override
    public FeatureDTO createFeature(FeatureDTO featureDTO) {
        Feature feature = featureMapper.toEntity(featureDTO);
        Feature savedFeature = featureRepository.save(feature);
        return featureMapper.toDto(savedFeature);
    }

    @Override
    public FeatureDTO updateFeature(Long id, FeatureDTO featureDTO) {
        Feature existingFeature = featureRepository.findById(id).orElseThrow(() -> new RuntimeException("Feature not found"));
        existingFeature.setFeatureName(featureDTO.getFeatureName());
        Feature updatedFeature = featureRepository.save(existingFeature);
        return featureMapper.toDto(updatedFeature);
    }

    @Override
    public FeatureDTO getFeatureById(Long id) {
        Feature feature = featureRepository.findById(id).orElseThrow(() -> new RuntimeException("Feature not found"));
        return featureMapper.toDto(feature);
    }

    @Override
    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }

    @Override
    public List<FeatureDTO> getAllFeatures() {
        return featureRepository.findAll().stream()
                .map(featureMapper::toDto)
                .collect(Collectors.toList());
    }
}
