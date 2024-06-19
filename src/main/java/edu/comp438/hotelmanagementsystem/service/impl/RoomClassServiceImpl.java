package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.RoomClassDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClass;
import edu.comp438.hotelmanagementsystem.mapper.RoomClassMapper;
import edu.comp438.hotelmanagementsystem.repository.RoomClassRepository;
import edu.comp438.hotelmanagementsystem.service.RoomClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomClassServiceImpl implements RoomClassService {

    private final RoomClassRepository roomClassRepository;

    private final RoomClassMapper roomClassMapper;

    public RoomClassServiceImpl(RoomClassRepository roomClassRepository, RoomClassMapper roomClassMapper) {
        this.roomClassRepository = roomClassRepository;
        this.roomClassMapper = roomClassMapper;
    }

    @Override
    public RoomClassDTO createRoomClass(RoomClassDTO roomClassDTO) {
        RoomClass roomClass = roomClassMapper.toEntity(roomClassDTO);
        RoomClass savedRoomClass = roomClassRepository.save(roomClass);
        return roomClassMapper.toDto(savedRoomClass);
    }

    @Override
    public RoomClassDTO updateRoomClass(Long id, RoomClassDTO roomClassDTO) {
        RoomClass existingRoomClass = roomClassRepository.findById(id).orElseThrow(() -> new RuntimeException("RoomClass not found"));
        existingRoomClass.setClassName(roomClassDTO.getClassName());
        existingRoomClass.setBasePrice(roomClassDTO.getBasePrice());
        RoomClass updatedRoomClass = roomClassRepository.save(existingRoomClass);
        return roomClassMapper.toDto(updatedRoomClass);
    }

    @Override
    public RoomClassDTO getRoomClassById(Long id) {
        RoomClass roomClass = roomClassRepository.findById(id).orElseThrow(() -> new RuntimeException("RoomClass not found"));
        return roomClassMapper.toDto(roomClass);
    }

    @Override
    public void deleteRoomClass(Long id) {
        roomClassRepository.deleteById(id);
    }

    @Override
    public List<RoomClassDTO> getAllRoomClasses() {
        return roomClassRepository.findAll().stream()
                .map(roomClassMapper::toDto)
                .collect(Collectors.toList());
    }
}
