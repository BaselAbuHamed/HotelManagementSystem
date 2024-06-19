package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.EmployeeDTO;
import edu.comp438.hotelmanagementsystem.entity.Employee;
import edu.comp438.hotelmanagementsystem.controller.EmployeeController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EmployeeDTO> {

    @Override
    @NonNull
    public EmployeeDTO toModel(@NonNull Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmailAddress(),
                employee.getPhoneNumber(),
                employee.getRole().getId()
        );

        employeeDTO.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(employee.getId())).withSelfRel());
        return employeeDTO;
    }
}
