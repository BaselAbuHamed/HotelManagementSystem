package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.AddonDTO;
import edu.comp438.hotelmanagementsystem.entity.Addon;
import org.springframework.stereotype.Component;

@Component
public class AddonMapper {

    public AddonDTO toDto(Addon addon) {
        return new AddonDTO(
                addon.getId(),
                addon.getAddonName(),
                addon.getPrice()
        );
    }

    public Addon toEntity(AddonDTO addonDTO) {
        Addon addon = new Addon();
        addon.setId(addonDTO.getId());
        addon.setAddonName(addonDTO.getAddonName());
        addon.setPrice(addonDTO.getPrice());
        return addon;
    }
}
