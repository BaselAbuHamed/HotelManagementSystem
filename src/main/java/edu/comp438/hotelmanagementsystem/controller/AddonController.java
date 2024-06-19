package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.AddonDTO;
import edu.comp438.hotelmanagementsystem.service.AddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addons")
public class AddonController {

    private final AddonService addonService;

    @Autowired
    public AddonController(AddonService addonService) {
        this.addonService = addonService;
    }

    @PostMapping
    public ResponseEntity<AddonDTO> createAddon(@RequestBody AddonDTO addonDTO) {
        AddonDTO createdAddon = addonService.createAddon(addonDTO);
        return ResponseEntity.ok(createdAddon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddonDTO> updateAddon(@PathVariable Long id, @RequestBody AddonDTO addonDTO) {
        AddonDTO updatedAddon = addonService.updateAddon(id, addonDTO);
        return ResponseEntity.ok(updatedAddon);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddonDTO> getAddonById(@PathVariable Long id) {
        AddonDTO addonDTO = addonService.getAddonById(id);
        return ResponseEntity.ok(addonDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddon(@PathVariable Long id) {
        addonService.deleteAddon(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AddonDTO>> getAllAddons() {
        List<AddonDTO> addons = addonService.getAllAddons();
        return ResponseEntity.ok(addons);
    }
}
