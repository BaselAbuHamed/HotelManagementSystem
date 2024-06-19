package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.RoomClassFeatureDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClassFeature;
import edu.comp438.hotelmanagementsystem.entity.RoomClassFeatureId;
import edu.comp438.hotelmanagementsystem.mapper.RoomClassFeatureMapper;
import edu.comp438.hotelmanagementsystem.repository.RoomClassFeatureRepository;
import edu.comp438.hotelmanagementsystem.service.RoomClassFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomClassFeatureServiceImpl implements RoomClassFeatureService {

    private final RoomClassFeatureRepository roomClassFeatureRepository;
    private final RoomClassFeatureMapper roomClassFeatureMapper;

    @Autowired
    public RoomClassFeatureServiceImpl(RoomClassFeatureRepository roomClassFeatureRepository, RoomClassFeatureMapper roomClassFeatureMapper) {
        this.roomClassFeatureRepository = roomClassFeatureRepository;
        this.roomClassFeatureMapper = roomClassFeatureMapper;
    }

    @Override
    public RoomClassFeatureDTO createRoomClassFeature(RoomClassFeatureDTO roomClassFeatureDTO) {
        RoomClassFeature roomClassFeature = roomClassFeatureMapper.toEntity(roomClassFeatureDTO);
        RoomClassFeature savedRoomClassFeature = roomClassFeatureRepository.save(roomClassFeature);
        return roomClassFeatureMapper.toDto(savedRoomClassFeature);
    }

    @Override
    public RoomClassFeatureDTO updateRoomClassFeature(RoomClassFeatureId id, RoomClassFeatureDTO roomClassFeatureDTO) {
        RoomClassFeature existingRoomClassFeature = roomClassFeatureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomClassFeature not found"));
        // Update RoomClassFeature fields as needed
        RoomClassFeature updatedRoomClassFeature = roomClassFeatureRepository.save(existingRoomClassFeature);
        return roomClassFeatureMapper.toDto(updatedRoomClassFeature);
    }

    @Override
    public RoomClassFeatureDTO getRoomClassFeatureById(RoomClassFeatureId id) {
        RoomClassFeature roomClassFeature = roomClassFeatureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomClassFeature not found"));
        return roomClassFeatureMapper.toDto(roomClassFeature);
    }

    @Override
    public void deleteRoomClassFeature(RoomClassFeatureId id) {
        roomClassFeatureRepository.deleteById(id);
    }

    @Override
    public List<RoomClassFeatureDTO> getAllRoomClassFeatures() {
        return roomClassFeatureRepository.findAll().stream()
                .map(roomClassFeatureMapper::toDto)
                .collect(Collectors.toList());
    }
}
