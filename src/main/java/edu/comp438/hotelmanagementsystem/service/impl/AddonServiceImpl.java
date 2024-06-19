package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.AddonDTO;
import edu.comp438.hotelmanagementsystem.entity.Addon;
import edu.comp438.hotelmanagementsystem.mapper.AddonMapper;
import edu.comp438.hotelmanagementsystem.repository.AddonRepository;
import edu.comp438.hotelmanagementsystem.service.AddonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddonServiceImpl implements AddonService {

    private final AddonRepository addonRepository;

    private final AddonMapper addonMapper;

    public AddonServiceImpl(AddonRepository addonRepository, AddonMapper addonMapper) {
        this.addonRepository = addonRepository;
        this.addonMapper = addonMapper;
    }

    @Override
    public AddonDTO createAddon(AddonDTO addonDTO) {
        Addon addon = addonMapper.toEntity(addonDTO);
        Addon savedAddon = addonRepository.save(addon);
        return addonMapper.toDto(savedAddon);
    }

    @Override
    public AddonDTO updateAddon(Long id, AddonDTO addonDTO) {
        Addon existingAddon = addonRepository.findById(id).orElseThrow(() -> new RuntimeException("Addon not found"));
        existingAddon.setAddonName(addonDTO.getAddonName());
        existingAddon.setPrice(addonDTO.getPrice());
        Addon updatedAddon = addonRepository.save(existingAddon);
        return addonMapper.toDto(updatedAddon);
    }

    @Override
    public AddonDTO getAddonById(Long id) {
        Addon addon = addonRepository.findById(id).orElseThrow(() -> new RuntimeException("Addon not found"));
        return addonMapper.toDto(addon);
    }

    @Override
    public void deleteAddon(Long id) {
        addonRepository.deleteById(id);
    }

    @Override
    public List<AddonDTO> getAllAddons() {
        return addonRepository.findAll().stream()
                .map(addonMapper::toDto)
                .collect(Collectors.toList());
    }
}
