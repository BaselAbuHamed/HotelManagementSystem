package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.AddonDTO;
import java.util.List;

public interface AddonService {
    AddonDTO createAddon(AddonDTO addonDTO);
    AddonDTO updateAddon(Long id, AddonDTO addonDTO);
    AddonDTO getAddonById(Long id);
    void deleteAddon(Long id);
    List<AddonDTO> getAllAddons();
}
