package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.RoomClassBedTypeDTO;
import edu.comp438.hotelmanagementsystem.entity.BedType;
import edu.comp438.hotelmanagementsystem.entity.RoomClass;
import edu.comp438.hotelmanagementsystem.entity.RoomClassBedType;
import edu.comp438.hotelmanagementsystem.entity.RoomClassBedTypeId;
import edu.comp438.hotelmanagementsystem.repository.BedTypeRepository;
import edu.comp438.hotelmanagementsystem.repository.RoomClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomClassBedTypeMapper {

    private final RoomClassRepository roomClassRepository;
    private final BedTypeRepository bedTypeRepository;

    @Autowired
    public RoomClassBedTypeMapper(RoomClassRepository roomClassRepository, BedTypeRepository bedTypeRepository) {
        this.roomClassRepository = roomClassRepository;
        this.bedTypeRepository = bedTypeRepository;
    }

    public RoomClassBedTypeDTO toDto(RoomClassBedType roomClassBedType) {
        return new RoomClassBedTypeDTO(
                roomClassBedType.getId().getRoomClassId(),
                roomClassBedType.getId().getBedTypeId(),
                roomClassBedType.getNumBeds()
        );
    }

    public RoomClassBedType toEntity(RoomClassBedTypeDTO roomClassBedTypeDTO) {
        RoomClassBedTypeId roomClassBedTypeId = new RoomClassBedTypeId(roomClassBedTypeDTO.getRoomClassId(), roomClassBedTypeDTO.getBedTypeId());
        RoomClass roomClass = roomClassRepository.findById(roomClassBedTypeDTO.getRoomClassId())
                .orElseThrow(() -> new RuntimeException("Room class not found with given id : " + roomClassBedTypeDTO.getRoomClassId()));
        BedType bedType = bedTypeRepository.findById(roomClassBedTypeDTO.getBedTypeId())
                .orElseThrow(() -> new RuntimeException("Bed type not found with given id : " + roomClassBedTypeDTO.getBedTypeId()));

        RoomClassBedType roomClassBedType = new RoomClassBedType();
        roomClassBedType.setId(roomClassBedTypeId);
        roomClassBedType.setRoomClass(roomClass);
        roomClassBedType.setBedType(bedType);
        roomClassBedType.setNumBeds(roomClassBedTypeDTO.getNumBeds());
        return roomClassBedType;
    }
}
