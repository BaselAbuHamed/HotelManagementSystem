package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.RoomDTO;
import java.util.List;

public interface RoomService {
    RoomDTO createRoom(RoomDTO roomDTO);
    RoomDTO updateRoom(Long id, RoomDTO roomDTO);
    RoomDTO getRoomById(Long id);
    void deleteRoom(Long id);
    List<RoomDTO> getAllRooms();
}
