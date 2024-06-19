package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.RoomDTO;
import edu.comp438.hotelmanagementsystem.entity.Floor;
import edu.comp438.hotelmanagementsystem.entity.Room;
import edu.comp438.hotelmanagementsystem.entity.RoomClass;
import edu.comp438.hotelmanagementsystem.entity.RoomStatus;
import edu.comp438.hotelmanagementsystem.repository.FloorRepository;
import edu.comp438.hotelmanagementsystem.repository.RoomClassRepository;
import edu.comp438.hotelmanagementsystem.repository.RoomStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    private final FloorRepository floorRepository;
    private final RoomClassRepository roomClassRepository;
    private final RoomStatusRepository roomStatusRepository;

    @Autowired
    public RoomMapper(FloorRepository floorRepository, RoomClassRepository roomClassRepository, RoomStatusRepository roomStatusRepository) {
        this.floorRepository = floorRepository;
        this.roomClassRepository = roomClassRepository;
        this.roomStatusRepository = roomStatusRepository;
    }

    public RoomDTO toDto(Room room) {
        return new RoomDTO(
                room.getId(),
                room.getFloor().getId(),
                room.getRoomClass().getId(),
                room.getStatus().getId(),
                room.getRoomNumber()
        );
    }

    public Room toEntity(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());

        Floor floor = floorRepository.findById(roomDTO.getFloorId())
                .orElseThrow(() -> new RuntimeException("Floor not found with id: " + roomDTO.getFloorId()));
        room.setFloor(floor);

        RoomClass roomClass = roomClassRepository.findById(roomDTO.getRoomClassId())
                .orElseThrow(() -> new RuntimeException("Room class not found with id: " + roomDTO.getRoomClassId()));
        room.setRoomClass(roomClass);

        RoomStatus roomStatus = roomStatusRepository.findById(roomDTO.getStatusId())
                .orElseThrow(() -> new RuntimeException("Room status not found with id: " + roomDTO.getStatusId()));
        room.setStatus(roomStatus);

        room.setRoomNumber(roomDTO.getRoomNumber());

        return room;
    }
}
