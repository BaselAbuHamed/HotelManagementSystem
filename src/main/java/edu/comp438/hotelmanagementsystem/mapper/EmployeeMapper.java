package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.EmployeeDTO;
import edu.comp438.hotelmanagementsystem.entity.Employee;
import edu.comp438.hotelmanagementsystem.entity.Role;
import edu.comp438.hotelmanagementsystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private final RoleRepository roleRepository;

    @Autowired
    public EmployeeMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public EmployeeDTO toDto(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmailAddress(),
                employee.getPhoneNumber(),
                employee.getRole().getId()
        );
    }

    public Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmailAddress(employeeDTO.getEmailAddress());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());

        Role role = roleRepository.findById(employeeDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + employeeDTO.getRoleId()));
        employee.setRole(role);

        return employee;
    }
}
