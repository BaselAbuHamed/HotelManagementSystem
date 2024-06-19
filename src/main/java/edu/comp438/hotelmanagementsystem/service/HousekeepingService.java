package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.HousekeepingDTO;

import java.util.List;

public interface HousekeepingService {
    HousekeepingDTO createHousekeeping(HousekeepingDTO housekeepingDTO);
    HousekeepingDTO updateHousekeeping(Long id, HousekeepingDTO housekeepingDTO);
    HousekeepingDTO getHousekeepingById(Long id);
    void deleteHousekeeping(Long id);
    List<HousekeepingDTO> getAllHousekeepingTasks();
}
