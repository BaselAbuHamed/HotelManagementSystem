package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.HousekeepingDTO;
import edu.comp438.hotelmanagementsystem.entity.Employee;
import edu.comp438.hotelmanagementsystem.entity.Housekeeping;
import edu.comp438.hotelmanagementsystem.entity.Room;
import edu.comp438.hotelmanagementsystem.repository.EmployeeRepository;
import edu.comp438.hotelmanagementsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HousekeepingMapper {

    private final RoomRepository roomRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public HousekeepingMapper(RoomRepository roomRepository, EmployeeRepository employeeRepository) {
        this.roomRepository = roomRepository;
        this.employeeRepository = employeeRepository;
    }

    public HousekeepingDTO toDto(Housekeeping housekeeping) {
        return new HousekeepingDTO(
                housekeeping.getId(),
                housekeeping.getRoom().getId(),
                housekeeping.getEmployee().getId(),
                housekeeping.getTaskDate(),
                housekeeping.getTaskDescription(),
                housekeeping.getStatus()
        );
    }

    public Housekeeping toEntity(HousekeepingDTO housekeepingDTO) {
        Housekeeping housekeeping = new Housekeeping();
        housekeeping.setId(housekeepingDTO.getId());

        Room room = roomRepository.findById(housekeepingDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + housekeepingDTO.getRoomId()));
        housekeeping.setRoom(room);

        Employee employee = employeeRepository.findById(housekeepingDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + housekeepingDTO.getEmployeeId()));
        housekeeping.setEmployee(employee);

        housekeeping.setTaskDate(housekeepingDTO.getTaskDate());
        housekeeping.setTaskDescription(housekeepingDTO.getTaskDescription());
        housekeeping.setStatus(housekeepingDTO.getStatus());

        return housekeeping;
    }
}
