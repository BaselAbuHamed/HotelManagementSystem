package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.RoomStatusDTO;
import java.util.List;

public interface RoomStatusService {
    RoomStatusDTO createRoomStatus(RoomStatusDTO roomStatusDTO);
    RoomStatusDTO updateRoomStatus(Long id, RoomStatusDTO roomStatusDTO);
    RoomStatusDTO getRoomStatusById(Long id);
    void deleteRoomStatus(Long id);
    List<RoomStatusDTO> getAllRoomStatuses();
}
