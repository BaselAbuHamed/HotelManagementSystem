package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.BedTypeDTO;
import edu.comp438.hotelmanagementsystem.entity.BedType;
import edu.comp438.hotelmanagementsystem.mapper.BedTypeMapper;
import edu.comp438.hotelmanagementsystem.repository.BedTypeRepository;
import edu.comp438.hotelmanagementsystem.service.BedTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BedTypeServiceImpl implements BedTypeService {

    private final BedTypeRepository bedTypeRepository;

    private final BedTypeMapper bedTypeMapper;

    public BedTypeServiceImpl(BedTypeRepository bedTypeRepository, BedTypeMapper bedTypeMapper) {
        this.bedTypeRepository = bedTypeRepository;
        this.bedTypeMapper = bedTypeMapper;
    }

    @Override
    public BedTypeDTO createBedType(BedTypeDTO bedTypeDTO) {
        BedType bedType = bedTypeMapper.toEntity(bedTypeDTO);
        BedType savedBedType = bedTypeRepository.save(bedType);
        return bedTypeMapper.toDto(savedBedType);
    }

    @Override
    public BedTypeDTO updateBedType(Long id, BedTypeDTO bedTypeDTO) {
        BedType existingBedType = bedTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("BedType not found"));
        existingBedType.setBedTypeName(bedTypeDTO.getBedTypeName());
        BedType updatedBedType = bedTypeRepository.save(existingBedType);
        return bedTypeMapper.toDto(updatedBedType);
    }

    @Override
    public BedTypeDTO getBedTypeById(Long id) {
        BedType bedType = bedTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("BedType not found"));
        return bedTypeMapper.toDto(bedType);
    }

    @Override
    public void deleteBedType(Long id) {
        bedTypeRepository.deleteById(id);
    }

    @Override
    public List<BedTypeDTO> getAllBedTypes() {
        return bedTypeRepository.findAll().stream()
                .map(bedTypeMapper::toDto)
                .collect(Collectors.toList());
    }
}
