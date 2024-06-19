package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.RoomClassDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClass;
import org.springframework.stereotype.Component;

@Component
public class RoomClassMapper {

    public RoomClassDTO toDto(RoomClass roomClass) {
        return new RoomClassDTO(
                roomClass.getId(),
                roomClass.getClassName(),
                roomClass.getBasePrice()
        );
    }

    public RoomClass toEntity(RoomClassDTO roomClassDTO) {
        RoomClass roomClass = new RoomClass();
        roomClass.setId(roomClassDTO.getId());
        roomClass.setClassName(roomClassDTO.getClassName());
        roomClass.setBasePrice(roomClassDTO.getBasePrice());
        return roomClass;
    }
}