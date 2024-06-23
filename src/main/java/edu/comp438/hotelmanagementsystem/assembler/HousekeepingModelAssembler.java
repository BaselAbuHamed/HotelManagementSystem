package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.HousekeepingDTO;
import edu.comp438.hotelmanagementsystem.dto.RoomDTO;
import edu.comp438.hotelmanagementsystem.dto.EmployeeDTO;
import edu.comp438.hotelmanagementsystem.entity.Housekeeping;
import edu.comp438.hotelmanagementsystem.controller.HousekeepingController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class HousekeepingModelAssembler implements RepresentationModelAssembler<Housekeeping, EntityModel<HousekeepingDTO> >{

    private final RoomModelAssembler roomModelAssembler;
    private final EmployeeModelAssembler employeeModelAssembler;

    public HousekeepingModelAssembler(RoomModelAssembler roomModelAssembler, EmployeeModelAssembler employeeModelAssembler) {
        this.roomModelAssembler = roomModelAssembler;
        this.employeeModelAssembler = employeeModelAssembler;
    }

    @Override
    @NonNull
    public EntityModel<HousekeepingDTO> toModel(@NonNull Housekeeping housekeeping) {
        EntityModel<RoomDTO> roomDTO = roomModelAssembler.toModel(housekeeping.getRoom());
        EntityModel<EmployeeDTO> employeeDTO = employeeModelAssembler.toModel(housekeeping.getEmployee());

        HousekeepingDTO housekeepingDTO = new HousekeepingDTO(
                housekeeping.getId(),
                Objects.requireNonNull(roomDTO.getContent()).getRoomClassId(),
                Objects.requireNonNull(employeeDTO.getContent()).getId(),
                housekeeping.getTaskDate(),
                housekeeping.getTaskDescription(),
                housekeeping.getStatus()
        );

        EntityModel<HousekeepingDTO> housekeepingEntityModel = EntityModel.of(housekeepingDTO);
        housekeepingEntityModel.add(linkTo(methodOn(HousekeepingController.class).getHousekeepingById(housekeeping.getId())).withSelfRel());
        return housekeepingEntityModel;
    }
}
