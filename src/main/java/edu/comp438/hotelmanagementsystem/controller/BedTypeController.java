package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.BedTypeDTO;
import edu.comp438.hotelmanagementsystem.service.BedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bedtypes")
public class BedTypeController {

    private final BedTypeService bedTypeService;

    @Autowired
    public BedTypeController(BedTypeService bedTypeService) {
        this.bedTypeService = bedTypeService;
    }

    @PostMapping
    public ResponseEntity<BedTypeDTO> createBedType(@RequestBody BedTypeDTO bedTypeDTO) {
        BedTypeDTO createdBedType = bedTypeService.createBedType(bedTypeDTO);
        return ResponseEntity.ok(createdBedType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BedTypeDTO> updateBedType(@PathVariable Long id, @RequestBody BedTypeDTO bedTypeDTO) {
        BedTypeDTO updatedBedType = bedTypeService.updateBedType(id, bedTypeDTO);
        return ResponseEntity.ok(updatedBedType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BedTypeDTO> getBedTypeById(@PathVariable Long id) {
        BedTypeDTO bedTypeDTO = bedTypeService.getBedTypeById(id);
        return ResponseEntity.ok(bedTypeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBedType(@PathVariable Long id) {
        bedTypeService.deleteBedType(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BedTypeDTO>> getAllBedTypes() {
        List<BedTypeDTO> bedTypes = bedTypeService.getAllBedTypes();
        return ResponseEntity.ok(bedTypes);
    }
}
