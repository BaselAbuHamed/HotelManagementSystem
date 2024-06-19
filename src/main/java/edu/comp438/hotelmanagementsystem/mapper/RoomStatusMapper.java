package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.RoomStatusDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomStatus;
import org.springframework.stereotype.Component;

@Component
public class RoomStatusMapper {

    public RoomStatusDTO toDto(RoomStatus roomStatus) {
        return new RoomStatusDTO(
                roomStatus.getId(),
                roomStatus.getStatusName()
        );
    }

    public RoomStatus toEntity(RoomStatusDTO roomStatusDTO) {
        RoomStatus roomStatus = new RoomStatus();
        roomStatus.setId(roomStatusDTO.getId());
        roomStatus.setStatusName(roomStatusDTO.getStatusName());
        return roomStatus;
    }
}
