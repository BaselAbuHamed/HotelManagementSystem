package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.RoomClassFeatureDTO;
import edu.comp438.hotelmanagementsystem.entity.Feature;
import edu.comp438.hotelmanagementsystem.entity.RoomClass;
import edu.comp438.hotelmanagementsystem.entity.RoomClassFeature;
import edu.comp438.hotelmanagementsystem.entity.RoomClassFeatureId;
import edu.comp438.hotelmanagementsystem.repository.FeatureRepository;
import edu.comp438.hotelmanagementsystem.repository.RoomClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomClassFeatureMapper {

    private final RoomClassRepository roomClassRepository;
    private final FeatureRepository featureRepository;

    @Autowired
    public RoomClassFeatureMapper(RoomClassRepository roomClassRepository, FeatureRepository featureRepository) {
        this.roomClassRepository = roomClassRepository;
        this.featureRepository = featureRepository;
    }

    public RoomClassFeatureDTO toDto(RoomClassFeature roomClassFeature) {
        return new RoomClassFeatureDTO(
                roomClassFeature.getId().getRoomClassId(),
                roomClassFeature.getId().getFeatureId()
        );
    }

    public RoomClassFeature toEntity(RoomClassFeatureDTO roomClassFeatureDTO) {
        RoomClassFeatureId roomClassFeatureId = new RoomClassFeatureId(roomClassFeatureDTO.getRoomClassId(), roomClassFeatureDTO.getFeatureId());
        RoomClass roomClass = roomClassRepository.findById(roomClassFeatureDTO.getRoomClassId())
                .orElseThrow(() -> new RuntimeException("Room class not found with given id : " + roomClassFeatureDTO.getRoomClassId()));
        Feature feature = featureRepository.findById(roomClassFeatureDTO.getFeatureId())
                .orElseThrow(() -> new RuntimeException("Feature not found with given id : " + roomClassFeatureDTO.getFeatureId()));

        RoomClassFeature roomClassFeature = new RoomClassFeature();
        roomClassFeature.setId(roomClassFeatureId);
        roomClassFeature.setRoomClass(roomClass);
        roomClassFeature.setFeature(feature);
        return roomClassFeature;
    }
}
