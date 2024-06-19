package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.RoomClassBedTypeDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClassBedTypeId;

import java.util.List;

public interface RoomClassBedTypeService {
    RoomClassBedTypeDTO createRoomClassBedType(RoomClassBedTypeDTO roomClassBedTypeDTO);
    RoomClassBedTypeDTO updateRoomClassBedType(RoomClassBedTypeId id, RoomClassBedTypeDTO roomClassBedTypeDTO);
    RoomClassBedTypeDTO getRoomClassBedTypeById(RoomClassBedTypeId id);
    void deleteRoomClassBedType(RoomClassBedTypeId id);
    List<RoomClassBedTypeDTO> getAllRoomClassBedTypes();
}
