package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.FloorDTO;
import edu.comp438.hotelmanagementsystem.entity.Floor;
import org.springframework.stereotype.Component;

@Component
public class FloorMapper {

    public FloorDTO toDto(Floor floor) {
        return new FloorDTO(
                floor.getId(),
                floor.getFloorNumber()
        );
    }

    public Floor toEntity(FloorDTO floorDTO) {
        Floor floor = new Floor();
        floor.setId(floorDTO.getId());
        floor.setFloorNumber(floorDTO.getFloorNumber());
        return floor;
    }
}
