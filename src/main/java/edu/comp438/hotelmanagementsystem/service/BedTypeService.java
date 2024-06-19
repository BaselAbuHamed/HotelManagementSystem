package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.BedTypeDTO;
import java.util.List;

public interface BedTypeService {
    BedTypeDTO createBedType(BedTypeDTO bedTypeDTO);
    BedTypeDTO updateBedType(Long id, BedTypeDTO bedTypeDTO);
    BedTypeDTO getBedTypeById(Long id);
    void deleteBedType(Long id);
    List<BedTypeDTO> getAllBedTypes();
}
