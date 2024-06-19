package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.RoomClassBedTypeDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClassBedTypeId;
import edu.comp438.hotelmanagementsystem.service.RoomClassBedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roomclassbedtypes")
public class RoomClassBedTypeController {

    private final RoomClassBedTypeService roomClassBedTypeService;

    @Autowired
    public RoomClassBedTypeController(RoomClassBedTypeService roomClassBedTypeService) {
        this.roomClassBedTypeService = roomClassBedTypeService;
    }

    @PostMapping
    public ResponseEntity<RoomClassBedTypeDTO> createRoomClassBedType(@RequestBody RoomClassBedTypeDTO roomClassBedTypeDTO) {
        RoomClassBedTypeDTO createdRoomClassBedType = roomClassBedTypeService.createRoomClassBedType(roomClassBedTypeDTO);
        return ResponseEntity.ok(createdRoomClassBedType);
    }

    @PutMapping("/{roomClassId}/{bedTypeId}")
    public ResponseEntity<RoomClassBedTypeDTO> updateRoomClassBedType(@PathVariable Long roomClassId, @PathVariable Long bedTypeId, @RequestBody RoomClassBedTypeDTO roomClassBedTypeDTO) {
        RoomClassBedTypeId id = new RoomClassBedTypeId(roomClassId, bedTypeId);
        RoomClassBedTypeDTO updatedRoomClassBedType = roomClassBedTypeService.updateRoomClassBedType(id, roomClassBedTypeDTO);
        return ResponseEntity.ok(updatedRoomClassBedType);
    }

    @GetMapping("/{roomClassId}/{bedTypeId}")
    public ResponseEntity<RoomClassBedTypeDTO> getRoomClassBedTypeById(@PathVariable Long roomClassId, @PathVariable Long bedTypeId) {
        RoomClassBedTypeId id = new RoomClassBedTypeId(roomClassId, bedTypeId);
        RoomClassBedTypeDTO roomClassBedTypeDTO = roomClassBedTypeService.getRoomClassBedTypeById(id);
        return ResponseEntity.ok(roomClassBedTypeDTO);
    }

    @DeleteMapping("/{roomClassId}/{bedTypeId}")
    public ResponseEntity<Void> deleteRoomClassBedType(@PathVariable Long roomClassId, @PathVariable Long bedTypeId) {
        RoomClassBedTypeId id = new RoomClassBedTypeId(roomClassId, bedTypeId);
        roomClassBedTypeService.deleteRoomClassBedType(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RoomClassBedTypeDTO>> getAllRoomClassBedTypes() {
        List<RoomClassBedTypeDTO> roomClassBedTypes = roomClassBedTypeService.getAllRoomClassBedTypes();
        return ResponseEntity.ok(roomClassBedTypes);
    }
}
