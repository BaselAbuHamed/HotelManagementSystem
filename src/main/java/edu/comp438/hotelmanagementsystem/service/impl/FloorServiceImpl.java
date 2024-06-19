package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.FloorDTO;
import edu.comp438.hotelmanagementsystem.entity.Floor;
import edu.comp438.hotelmanagementsystem.mapper.FloorMapper;
import edu.comp438.hotelmanagementsystem.repository.FloorRepository;
import edu.comp438.hotelmanagementsystem.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FloorServiceImpl implements FloorService {

    private final FloorRepository floorRepository;

    private final FloorMapper floorMapper;

    public FloorServiceImpl(FloorRepository floorRepository, FloorMapper floorMapper) {
        this.floorRepository = floorRepository;
        this.floorMapper = floorMapper;
    }

    @Override
    public FloorDTO createFloor(FloorDTO floorDTO) {
        Floor floor = floorMapper.toEntity(floorDTO);
        Floor savedFloor = floorRepository.save(floor);
        return floorMapper.toDto(savedFloor);
    }

    @Override
    public FloorDTO updateFloor(Long id, FloorDTO floorDTO) {
        Floor existingFloor = floorRepository.findById(id).orElseThrow(() -> new RuntimeException("Floor not found"));
        existingFloor.setFloorNumber(floorDTO.getFloorNumber());
        Floor updatedFloor = floorRepository.save(existingFloor);
        return floorMapper.toDto(updatedFloor);
    }

    @Override
    public FloorDTO getFloorById(Long id) {
        Floor floor = floorRepository.findById(id).orElseThrow(() -> new RuntimeException("Floor not found"));
        return floorMapper.toDto(floor);
    }

    @Override
    public void deleteFloor(Long id) {
        floorRepository.deleteById(id);
    }

    @Override
    public List<FloorDTO> getAllFloors() {
        return floorRepository.findAll().stream()
                .map(floorMapper::toDto)
                .collect(Collectors.toList());
    }
}
