package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.RoomStatusDTO;
import edu.comp438.hotelmanagementsystem.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roomstatus")
public class RoomStatusController {

    private final RoomStatusService roomStatusService;

    @Autowired
    public RoomStatusController(RoomStatusService roomStatusService) {
        this.roomStatusService = roomStatusService;
    }

    @PostMapping
    public ResponseEntity<RoomStatusDTO> createRoomStatus(@RequestBody RoomStatusDTO roomStatusDTO) {
        RoomStatusDTO createdRoomStatus = roomStatusService.createRoomStatus(roomStatusDTO);
        return ResponseEntity.ok(createdRoomStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomStatusDTO> updateRoomStatus(@PathVariable Long id, @RequestBody RoomStatusDTO roomStatusDTO) {
        RoomStatusDTO updatedRoomStatus = roomStatusService.updateRoomStatus(id, roomStatusDTO);
        return ResponseEntity.ok(updatedRoomStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomStatusDTO> getRoomStatusById(@PathVariable Long id) {
        RoomStatusDTO roomStatusDTO = roomStatusService.getRoomStatusById(id);
        return ResponseEntity.ok(roomStatusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomStatus(@PathVariable Long id) {
        roomStatusService.deleteRoomStatus(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RoomStatusDTO>> getAllRoomStatus() {
        List<RoomStatusDTO> roomStatusList = roomStatusService.getAllRoomStatuses();
        return ResponseEntity.ok(roomStatusList);
    }
}
