package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.RoomClassFeatureDTO;
import edu.comp438.hotelmanagementsystem.entity.RoomClassFeatureId;
import java.util.List;

public interface RoomClassFeatureService {
    RoomClassFeatureDTO createRoomClassFeature(RoomClassFeatureDTO roomClassFeatureDTO);
    RoomClassFeatureDTO updateRoomClassFeature(RoomClassFeatureId id, RoomClassFeatureDTO roomClassFeatureDTO);
    RoomClassFeatureDTO getRoomClassFeatureById(RoomClassFeatureId id);
    void deleteRoomClassFeature(RoomClassFeatureId id);
    List<RoomClassFeatureDTO> getAllRoomClassFeatures();
}
