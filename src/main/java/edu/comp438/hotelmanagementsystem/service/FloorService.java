package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.FloorDTO;
import java.util.List;

public interface FloorService {
    FloorDTO createFloor(FloorDTO floorDTO);
    FloorDTO updateFloor(Long id, FloorDTO floorDTO);
    FloorDTO getFloorById(Long id);
    void deleteFloor(Long id);
    List<FloorDTO> getAllFloors();
}
