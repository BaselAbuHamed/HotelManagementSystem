package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.RoomStatusDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomStatus;
import edu.comp438.hotelmanagementsystem.mapper.RoomStatusMapper;
import edu.comp438.hotelmanagementsystem.repository.RoomStatusRepository;
import edu.comp438.hotelmanagementsystem.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {

    private final RoomStatusRepository roomStatusRepository;

    private final RoomStatusMapper roomStatusMapper;

    public RoomStatusServiceImpl(RoomStatusRepository roomStatusRepository, RoomStatusMapper roomStatusMapper) {
        this.roomStatusRepository = roomStatusRepository;
        this.roomStatusMapper = roomStatusMapper;
    }

    @Override
    public RoomStatusDTO createRoomStatus(RoomStatusDTO roomStatusDTO) {
        RoomStatus roomStatus = roomStatusMapper.toEntity(roomStatusDTO);
        RoomStatus savedRoomStatus = roomStatusRepository.save(roomStatus);
        return roomStatusMapper.toDto(savedRoomStatus);
    }

    @Override
    public RoomStatusDTO updateRoomStatus(Long id, RoomStatusDTO roomStatusDTO) {
        RoomStatus existingRoomStatus = roomStatusRepository.findById(id).orElseThrow(() -> new RuntimeException("RoomStatus not found"));
        existingRoomStatus.setStatusName(roomStatusDTO.getStatusName());
        RoomStatus updatedRoomStatus = roomStatusRepository.save(existingRoomStatus);
        return roomStatusMapper.toDto(updatedRoomStatus);
    }

    @Override
    public RoomStatusDTO getRoomStatusById(Long id) {
        RoomStatus roomStatus = roomStatusRepository.findById(id).orElseThrow(() -> new RuntimeException("RoomStatus not found"));
        return roomStatusMapper.toDto(roomStatus);
    }

    @Override
    public void deleteRoomStatus(Long id) {
        roomStatusRepository.deleteById(id);
    }

    @Override
    public List<RoomStatusDTO> getAllRoomStatuses() {
        return roomStatusRepository.findAll().stream()
                .map(roomStatusMapper::toDto)
                .collect(Collectors.toList());
    }
}
