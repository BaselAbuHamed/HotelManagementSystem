package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.RoomClassDTO;
import edu.comp438.hotelmanagementsystem.service.RoomClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roomclasses")
public class RoomClassController {

    private final RoomClassService roomClassService;

    @Autowired
    public RoomClassController(RoomClassService roomClassService) {
        this.roomClassService = roomClassService;
    }

    @PostMapping
    public ResponseEntity<RoomClassDTO> createRoomClass(@RequestBody RoomClassDTO roomClassDTO) {
        RoomClassDTO createdRoomClass = roomClassService.createRoomClass(roomClassDTO);
        return ResponseEntity.ok(createdRoomClass);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomClassDTO> updateRoomClass(@PathVariable Long id, @RequestBody RoomClassDTO roomClassDTO) {
        RoomClassDTO updatedRoomClass = roomClassService.updateRoomClass(id, roomClassDTO);
        return ResponseEntity.ok(updatedRoomClass);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomClassDTO> getRoomClassById(@PathVariable Long id) {
        RoomClassDTO roomClassDTO = roomClassService.getRoomClassById(id);
        return ResponseEntity.ok(roomClassDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomClass(@PathVariable Long id) {
        roomClassService.deleteRoomClass(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RoomClassDTO>> getAllRoomClasses() {
        List<RoomClassDTO> roomClasses = roomClassService.getAllRoomClasses();
        return ResponseEntity.ok(roomClasses);
    }
}
