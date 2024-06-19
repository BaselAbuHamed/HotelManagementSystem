package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.HousekeepingDTO;
import edu.comp438.hotelmanagementsystem.entity.Housekeeping;
import edu.comp438.hotelmanagementsystem.entity.Room;
import edu.comp438.hotelmanagementsystem.entity.Employee;
import edu.comp438.hotelmanagementsystem.mapper.HousekeepingMapper;
import edu.comp438.hotelmanagementsystem.repository.HousekeepingRepository;
import edu.comp438.hotelmanagementsystem.repository.RoomRepository;
import edu.comp438.hotelmanagementsystem.repository.EmployeeRepository;
import edu.comp438.hotelmanagementsystem.service.HousekeepingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HousekeepingServiceImpl implements HousekeepingService {

    private final HousekeepingRepository housekeepingRepository;
    private final RoomRepository roomRepository;
    private final EmployeeRepository employeeRepository;
    private final HousekeepingMapper housekeepingMapper;

    public HousekeepingServiceImpl(HousekeepingRepository housekeepingRepository, RoomRepository roomRepository, EmployeeRepository employeeRepository, HousekeepingMapper housekeepingMapper) {
        this.housekeepingRepository = housekeepingRepository;
        this.roomRepository = roomRepository;
        this.employeeRepository = employeeRepository;
        this.housekeepingMapper = housekeepingMapper;
    }

    @Override
    public HousekeepingDTO createHousekeeping(HousekeepingDTO housekeepingDTO) {
        Housekeeping housekeeping = housekeepingMapper.toEntity(housekeepingDTO);

        Room room = roomRepository.findById(housekeepingDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + housekeepingDTO.getRoomId()));
        Employee employee = employeeRepository.findById(housekeepingDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + housekeepingDTO.getEmployeeId()));

        housekeeping.setRoom(room);
        housekeeping.setEmployee(employee);

        Housekeeping savedHousekeeping = housekeepingRepository.save(housekeeping);
        return housekeepingMapper.toDto(savedHousekeeping);
    }

    @Override
    public HousekeepingDTO updateHousekeeping(Long id, HousekeepingDTO housekeepingDTO) {
        Housekeeping existingHousekeeping = housekeepingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Housekeeping task not found"));

        Room room = roomRepository.findById(housekeepingDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + housekeepingDTO.getRoomId()));
        Employee employee = employeeRepository.findById(housekeepingDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + housekeepingDTO.getEmployeeId()));

        existingHousekeeping.setRoom(room);
        existingHousekeeping.setEmployee(employee);
        existingHousekeeping.setTaskDate(housekeepingDTO.getTaskDate());
        existingHousekeeping.setTaskDescription(housekeepingDTO.getTaskDescription());
        existingHousekeeping.setStatus(housekeepingDTO.getStatus());

        Housekeeping updatedHousekeeping = housekeepingRepository.save(existingHousekeeping);
        return housekeepingMapper.toDto(updatedHousekeeping);
    }

    @Override
    public HousekeepingDTO getHousekeepingById(Long id) {
        Housekeeping housekeeping = housekeepingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Housekeeping task not found"));
        return housekeepingMapper.toDto(housekeeping);
    }

    @Override
    public void deleteHousekeeping(Long id) {
        housekeepingRepository.deleteById(id);
    }

    @Override
    public List<HousekeepingDTO> getAllHousekeepingTasks() {
        return housekeepingRepository.findAll().stream()
                .map(housekeepingMapper::toDto)
                .collect(Collectors.toList());
    }
}
