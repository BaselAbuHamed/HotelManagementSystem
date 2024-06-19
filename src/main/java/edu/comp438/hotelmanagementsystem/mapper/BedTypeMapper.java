package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.BedTypeDTO;
import edu.comp438.hotelmanagementsystem.entity.BedType;
import org.springframework.stereotype.Component;

@Component
public class BedTypeMapper {

    public BedTypeDTO toDto(BedType bedType) {
        return new BedTypeDTO(
                bedType.getId(),
                bedType.getBedTypeName()
        );
    }

    public BedType toEntity(BedTypeDTO bedTypeDTO) {
        BedType bedType = new BedType();
        bedType.setId(bedTypeDTO.getId());
        bedType.setBedTypeName(bedTypeDTO.getBedTypeName());
        return bedType;
    }
}
