package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.FloorDTO;
import edu.comp438.hotelmanagementsystem.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/floors")
public class FloorController {

    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping
    public ResponseEntity<FloorDTO> createFloor(@RequestBody FloorDTO floorDTO) {
        FloorDTO createdFloor = floorService.createFloor(floorDTO);
        return ResponseEntity.ok(createdFloor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FloorDTO> updateFloor(@PathVariable Long id, @RequestBody FloorDTO floorDTO) {
        FloorDTO updatedFloor = floorService.updateFloor(id, floorDTO);
        return ResponseEntity.ok(updatedFloor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FloorDTO> getFloorById(@PathVariable Long id) {
        FloorDTO floorDTO = floorService.getFloorById(id);
        return ResponseEntity.ok(floorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFloor(@PathVariable Long id) {
        floorService.deleteFloor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FloorDTO>> getAllFloors() {
        List<FloorDTO> floors = floorService.getAllFloors();
        return ResponseEntity.ok(floors);
    }
}
