package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.HousekeepingDTO;
import edu.comp438.hotelmanagementsystem.dto.RoomDTO;
import edu.comp438.hotelmanagementsystem.dto.EmployeeDTO;
import edu.comp438.hotelmanagementsystem.entity.Housekeeping;
import edu.comp438.hotelmanagementsystem.controller.HousekeepingController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class HousekeepingModelAssembler implements RepresentationModelAssembler<Housekeeping, HousekeepingDTO> {

    private final RoomModelAssembler roomModelAssembler;
    private final EmployeeModelAssembler employeeModelAssembler;

    public HousekeepingModelAssembler(RoomModelAssembler roomModelAssembler, EmployeeModelAssembler employeeModelAssembler) {
        this.roomModelAssembler = roomModelAssembler;
        this.employeeModelAssembler = employeeModelAssembler;
    }

    @Override
    @NonNull
    public HousekeepingDTO toModel(@NonNull Housekeeping housekeeping) {
        RoomDTO roomDTO = roomModelAssembler.toModel(housekeeping.getRoom());
        EmployeeDTO employeeDTO = employeeModelAssembler.toModel(housekeeping.getEmployee());

        HousekeepingDTO housekeepingDTO = new HousekeepingDTO(
                housekeeping.getId(),
                roomDTO.getId(),
                employeeDTO.getId(),
                housekeeping.getTaskDate(),
                housekeeping.getTaskDescription(),
                housekeeping.getStatus()
        );

        housekeepingDTO.add(linkTo(methodOn(HousekeepingController.class).getHousekeepingById(housekeeping.getId())).withSelfRel());
        return housekeepingDTO;
    }
}
