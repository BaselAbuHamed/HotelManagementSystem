package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.RoomClassBedTypeDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClassBedType;
import edu.comp438.hotelmanagementsystem.entity.RoomClassBedTypeId;
import edu.comp438.hotelmanagementsystem.mapper.RoomClassBedTypeMapper;
import edu.comp438.hotelmanagementsystem.repository.RoomClassBedTypeRepository;
import edu.comp438.hotelmanagementsystem.service.RoomClassBedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomClassBedTypeServiceImpl implements RoomClassBedTypeService {

    private final RoomClassBedTypeRepository roomClassBedTypeRepository;
    private final RoomClassBedTypeMapper roomClassBedTypeMapper;

    @Autowired
    public RoomClassBedTypeServiceImpl(RoomClassBedTypeRepository roomClassBedTypeRepository, RoomClassBedTypeMapper roomClassBedTypeMapper) {
        this.roomClassBedTypeRepository = roomClassBedTypeRepository;
        this.roomClassBedTypeMapper = roomClassBedTypeMapper;
    }

    @Override
    public RoomClassBedTypeDTO createRoomClassBedType(RoomClassBedTypeDTO roomClassBedTypeDTO) {
        RoomClassBedType roomClassBedType = roomClassBedTypeMapper.toEntity(roomClassBedTypeDTO);
        RoomClassBedType savedRoomClassBedType = roomClassBedTypeRepository.save(roomClassBedType);
        return roomClassBedTypeMapper.toDto(savedRoomClassBedType);
    }

    @Override
    public RoomClassBedTypeDTO updateRoomClassBedType(RoomClassBedTypeId id, RoomClassBedTypeDTO roomClassBedTypeDTO) {
        RoomClassBedType existingRoomClassBedType = roomClassBedTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomClassBedType not found"));
        existingRoomClassBedType.setNumBeds(roomClassBedTypeDTO.getNumBeds());
        RoomClassBedType updatedRoomClassBedType = roomClassBedTypeRepository.save(existingRoomClassBedType);
        return roomClassBedTypeMapper.toDto(updatedRoomClassBedType);
    }

    @Override
    public RoomClassBedTypeDTO getRoomClassBedTypeById(RoomClassBedTypeId id) {
        RoomClassBedType roomClassBedType = roomClassBedTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomClassBedType not found"));
        return roomClassBedTypeMapper.toDto(roomClassBedType);
    }

    @Override
    public void deleteRoomClassBedType(RoomClassBedTypeId id) {
        roomClassBedTypeRepository.deleteById(id);
    }

    @Override
    public List<RoomClassBedTypeDTO> getAllRoomClassBedTypes() {
        return roomClassBedTypeRepository.findAll().stream()
                .map(roomClassBedTypeMapper::toDto)
                .collect(Collectors.toList());
    }
}
