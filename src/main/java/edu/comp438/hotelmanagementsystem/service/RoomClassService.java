package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.RoomClassDTO;
import java.util.List;

public interface RoomClassService {
    RoomClassDTO createRoomClass(RoomClassDTO roomClassDTO);
    RoomClassDTO updateRoomClass(Long id, RoomClassDTO roomClassDTO);
    RoomClassDTO getRoomClassById(Long id);
    void deleteRoomClass(Long id);
    List<RoomClassDTO> getAllRoomClasses();
}
