package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.RoomDTO;
import edu.comp438.hotelmanagementsystem.entity.Room;
import edu.comp438.hotelmanagementsystem.mapper.RoomMapper;
import edu.comp438.hotelmanagementsystem.repository.RoomRepository;
import edu.comp438.hotelmanagementsystem.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room room = roomMapper.toEntity(roomDTO);
        Room savedRoom = roomRepository.save(room);
        return roomMapper.toDto(savedRoom);
    }

    @Override
    public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        existingRoom.setFloor(roomMapper.toEntity(roomDTO).getFloor());
        existingRoom.setRoomClass(roomMapper.toEntity(roomDTO).getRoomClass());
        existingRoom.setStatus(roomMapper.toEntity(roomDTO).getStatus());
        existingRoom.setRoomNumber(roomDTO.getRoomNumber());

        Room updatedRoom = roomRepository.save(existingRoom);
        return roomMapper.toDto(updatedRoom);
    }

    @Override
    public RoomDTO getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        return roomMapper.toDto(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(roomMapper::toDto)
                .collect(Collectors.toList());
    }
}
