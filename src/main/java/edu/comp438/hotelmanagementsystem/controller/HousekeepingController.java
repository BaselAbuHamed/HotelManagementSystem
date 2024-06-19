package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.HousekeepingDTO;
import edu.comp438.hotelmanagementsystem.service.HousekeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/housekeeping")
public class HousekeepingController {

    private final HousekeepingService housekeepingService;

    @Autowired
    public HousekeepingController(HousekeepingService housekeepingService) {
        this.housekeepingService = housekeepingService;
    }

    @PostMapping
    public ResponseEntity<HousekeepingDTO> createHousekeeping(@RequestBody HousekeepingDTO housekeepingDTO) {
        HousekeepingDTO createdHousekeeping = housekeepingService.createHousekeeping(housekeepingDTO);
        return ResponseEntity.ok(createdHousekeeping);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HousekeepingDTO> updateHousekeeping(@PathVariable Long id, @RequestBody HousekeepingDTO housekeepingDTO) {
        HousekeepingDTO updatedHousekeeping = housekeepingService.updateHousekeeping(id, housekeepingDTO);
        return ResponseEntity.ok(updatedHousekeeping);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HousekeepingDTO> getHousekeepingById(@PathVariable Long id) {
        HousekeepingDTO housekeepingDTO = housekeepingService.getHousekeepingById(id);
        return ResponseEntity.ok(housekeepingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHousekeeping(@PathVariable Long id) {
        housekeepingService.deleteHousekeeping(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<HousekeepingDTO>> getAllHousekeeping() {
        List<HousekeepingDTO> housekeepingTasks = housekeepingService.getAllHousekeepingTasks();
        return ResponseEntity.ok(housekeepingTasks);
    }
}
