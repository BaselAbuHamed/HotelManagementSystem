package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.RoomClassFeatureDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClassFeatureId;
import edu.comp438.hotelmanagementsystem.service.RoomClassFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roomclassfeatures")
public class RoomClassFeatureController {

    private final RoomClassFeatureService roomClassFeatureService;

    @Autowired
    public RoomClassFeatureController(RoomClassFeatureService roomClassFeatureService) {
        this.roomClassFeatureService = roomClassFeatureService;
    }

    @PostMapping
    public ResponseEntity<RoomClassFeatureDTO> createRoomClassFeature(@RequestBody RoomClassFeatureDTO roomClassFeatureDTO) {
        RoomClassFeatureDTO createdRoomClassFeature = roomClassFeatureService.createRoomClassFeature(roomClassFeatureDTO);
        return ResponseEntity.ok(createdRoomClassFeature);
    }

    @PutMapping("/{roomClassId}/{featureId}")
    public ResponseEntity<RoomClassFeatureDTO> updateRoomClassFeature(@PathVariable Long roomClassId, @PathVariable Long featureId, @RequestBody RoomClassFeatureDTO roomClassFeatureDTO) {
        RoomClassFeatureId id = new RoomClassFeatureId(roomClassId, featureId);
        RoomClassFeatureDTO updatedRoomClassFeature = roomClassFeatureService.updateRoomClassFeature(id, roomClassFeatureDTO);
        return ResponseEntity.ok(updatedRoomClassFeature);
    }

    @GetMapping("/{roomClassId}/{featureId}")
    public ResponseEntity<RoomClassFeatureDTO> getRoomClassFeatureById(@PathVariable Long roomClassId, @PathVariable Long featureId) {
        RoomClassFeatureId id = new RoomClassFeatureId(roomClassId, featureId);
        RoomClassFeatureDTO roomClassFeatureDTO = roomClassFeatureService.getRoomClassFeatureById(id);
        return ResponseEntity.ok(roomClassFeatureDTO);
    }

    @DeleteMapping("/{roomClassId}/{featureId}")
    public ResponseEntity<Void> deleteRoomClassFeature(@PathVariable Long roomClassId, @PathVariable Long featureId) {
        RoomClassFeatureId id = new RoomClassFeatureId(roomClassId, featureId);
        roomClassFeatureService.deleteRoomClassFeature(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RoomClassFeatureDTO>> getAllRoomClassFeatures() {
        List<RoomClassFeatureDTO> roomClassFeatures = roomClassFeatureService.getAllRoomClassFeatures();
        return ResponseEntity.ok(roomClassFeatures);
    }
}
