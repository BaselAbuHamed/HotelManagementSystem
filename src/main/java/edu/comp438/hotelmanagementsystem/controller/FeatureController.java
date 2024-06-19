package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.FeatureDTO;
import edu.comp438.hotelmanagementsystem.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/features")
public class FeatureController {

    private final FeatureService featureService;

    @Autowired
    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @PostMapping
    public ResponseEntity<FeatureDTO> createFeature(@RequestBody FeatureDTO featureDTO) {
        FeatureDTO createdFeature = featureService.createFeature(featureDTO);
        return ResponseEntity.ok(createdFeature);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeatureDTO> updateFeature(@PathVariable Long id, @RequestBody FeatureDTO featureDTO) {
        FeatureDTO updatedFeature = featureService.updateFeature(id, featureDTO);
        return ResponseEntity.ok(updatedFeature);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureDTO> getFeatureById(@PathVariable Long id) {
        FeatureDTO featureDTO = featureService.getFeatureById(id);
        return ResponseEntity.ok(featureDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FeatureDTO>> getAllFeatures() {
        List<FeatureDTO> features = featureService.getAllFeatures();
        return ResponseEntity.ok(features);
    }
}
